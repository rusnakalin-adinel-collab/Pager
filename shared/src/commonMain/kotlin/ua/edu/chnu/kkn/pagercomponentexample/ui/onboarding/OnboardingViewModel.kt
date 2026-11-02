package ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.edu.chnu.kkn.pagercomponentexample.data.repository.SettingsRepository
import ua.edu.chnu.kkn.pagercomponentexample.domain.usecase.SetOnboardingCompletedUseCase

class OnboardingViewModel(
    private val setOnboardingCompletedUseCase: SetOnboardingCompletedUseCase,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        OnboardingState(
            isUkrainian = settingsRepository.isUkrainianLanguage()
        )
    )
    val state: StateFlow<OnboardingState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<OnboardingEffect>()
    val effect: SharedFlow<OnboardingEffect> = _effect.asSharedFlow()

    fun processIntent(intent: OnboardingIntent) {
        when (intent) {
            is OnboardingIntent.PageChanged -> {
                _state.update { it.copy(currentPage = intent.page) }
            }

            is OnboardingIntent.NextClicked -> {
                val current = _state.value.currentPage
                if (current < _state.value.totalPages - 1) {
                    viewModelScope.launch {
                        _effect.emit(OnboardingEffect.AnimateToPage(current + 1))
                    }
                } else {
                    completeOnboarding()
                }
            }

            is OnboardingIntent.BackClicked -> {
                val current = _state.value.currentPage
                if (current > 0) {
                    viewModelScope.launch {
                        _effect.emit(OnboardingEffect.AnimateToPage(current - 1))
                    }
                }
            }

            is OnboardingIntent.SkipClicked,
            is OnboardingIntent.CompleteClicked -> {
                completeOnboarding()
            }

            is OnboardingIntent.LanguageToggled -> {
                settingsRepository.setUkrainianLanguage(intent.isUkrainian)
                _state.update { it.copy(isUkrainian = intent.isUkrainian) }
            }
        }
    }

    private fun completeOnboarding() {
        setOnboardingCompletedUseCase(true)
        _state.update { it.copy(isCompleted = true) }
        viewModelScope.launch {
            _effect.emit(OnboardingEffect.NavigateToAuth)
        }
    }
}
