package ua.edu.chnu.kkn.pagercomponentexample.ui.main

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.edu.chnu.kkn.pagercomponentexample.domain.usecase.IsOnboardingCompletedUseCase
import ua.edu.chnu.kkn.pagercomponentexample.ui.navigation.AppRoute

data class MainState(
    val initialRoute: AppRoute = AppRoute.Onboarding,
    val isOnboardingCompleted: Boolean = false,
    val isReady: Boolean = false
)

class MainViewModel(
    private val isOnboardingCompletedUseCase: IsOnboardingCompletedUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        checkOnboardingStatus()
    }

    fun checkOnboardingStatus() {
        val isCompleted = isOnboardingCompletedUseCase()
        _state.value = MainState(
            initialRoute = if (isCompleted) AppRoute.Auth else AppRoute.Onboarding,
            isOnboardingCompleted = isCompleted,
            isReady = true
        )
    }
}
