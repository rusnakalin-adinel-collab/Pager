package ua.edu.chnu.kkn.pagercomponentexample.ui.auth

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

class AuthViewModel(
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(
        AuthState(
            isUkrainian = settingsRepository.isUkrainianLanguage()
        )
    )
    val state: StateFlow<AuthState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<AuthEffect>()
    val effect: SharedFlow<AuthEffect> = _effect.asSharedFlow()

    fun processIntent(intent: AuthIntent) {
        when (intent) {
            is AuthIntent.UsernameChanged -> {
                _state.update {
                    it.copy(
                        username = intent.username,
                        usernameError = null
                    )
                }
            }

            is AuthIntent.PasswordChanged -> {
                _state.update {
                    it.copy(
                        password = intent.password,
                        passwordError = null
                    )
                }
            }

            is AuthIntent.TogglePasswordVisibility -> {
                _state.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
            }

            is AuthIntent.ToggleRememberMe -> {
                _state.update { it.copy(rememberMe = !it.rememberMe) }
            }

            is AuthIntent.ToggleLanguage -> {
                settingsRepository.setUkrainianLanguage(intent.isUkrainian)
                _state.update { it.copy(isUkrainian = intent.isUkrainian) }
            }

            is AuthIntent.SubmitLogin -> {
                validateAndSubmit()
            }

            is AuthIntent.GoogleLoginClicked -> {
                viewModelScope.launch {
                    val msg = if (_state.value.isUkrainian) {
                        "Вхід через Google активовано"
                    } else {
                        "Google login initiated"
                    }
                    _effect.emit(AuthEffect.ShowToast(msg))
                }
            }

            is AuthIntent.ForgotPasswordClicked -> {
                viewModelScope.launch {
                    val msg = if (_state.value.isUkrainian) {
                        "Форма відновлення пароля надіслана"
                    } else {
                        "Password reset link sent"
                    }
                    _effect.emit(AuthEffect.ShowToast(msg))
                }
            }

            is AuthIntent.BackClicked -> {
                viewModelScope.launch {
                    _effect.emit(AuthEffect.NavigateBack)
                }
            }
        }
    }

    private fun validateAndSubmit() {
        val currentState = _state.value
        val isUa = currentState.isUkrainian
        val username = currentState.username.trim()
        val password = currentState.password

        var hasError = false
        var usernameError: String? = null
        var passwordError: String? = null

        // 1. Username/Email/ID validation
        if (username.isBlank()) {
            hasError = true
            usernameError = if (isUa) {
                "Введіть email, телефон або ID атлета"
            } else {
                "Enter email, phone, or athlete ID"
            }
        } else if (username.contains("@")) {
            // Email format check
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
            if (!emailRegex.matches(username)) {
                hasError = true
                usernameError = if (isUa) "Некоректний формат email" else "Invalid email format"
            }
        } else if (username.startsWith("+") || username.all { it.isDigit() }) {
            // Phone format check
            val digitsOnly = username.filter { it.isDigit() }
            if (digitsOnly.length < 10) {
                hasError = true
                usernameError = if (isUa) "Номер телефону закороткий" else "Phone number is too short"
            }
        } else {
            // Athlete ID check
            if (username.length < 3) {
                hasError = true
                usernameError = if (isUa) "ID атлета мін. 3 символи" else "Athlete ID min. 3 characters"
            }
        }

        // 2. Password validation (min 6 characters as required)
        if (password.isBlank()) {
            hasError = true
            passwordError = if (isUa) {
                "Введіть пароль"
            } else {
                "Enter password"
            }
        } else if (password.length < 6) {
            hasError = true
            passwordError = if (isUa) {
                "Пароль повинен містити щонайменше 6 символів"
            } else {
                "Password must be at least 6 characters"
            }
        }

        if (hasError) {
            _state.update {
                it.copy(
                    usernameError = usernameError,
                    passwordError = passwordError
                )
            }
            return
        }

        // Valid submission
        _state.update {
            it.copy(
                isLoading = true,
                usernameError = null,
                passwordError = null
            )
        }

        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = false,
                    isSuccess = true
                )
            }
            val successMsg = if (isUa) "Успішний вхід до системи!" else "Successfully logged in!"
            _effect.emit(AuthEffect.ShowToast(successMsg))
            _effect.emit(AuthEffect.NavigateToHome)
        }
    }
}
