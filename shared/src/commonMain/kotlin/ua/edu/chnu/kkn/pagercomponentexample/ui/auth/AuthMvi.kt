package ua.edu.chnu.kkn.pagercomponentexample.ui.auth

sealed interface AuthIntent {
    data class UsernameChanged(val username: String) : AuthIntent
    data class PasswordChanged(val password: String) : AuthIntent
    data object TogglePasswordVisibility : AuthIntent
    data object ToggleRememberMe : AuthIntent
    data class ToggleLanguage(val isUkrainian: Boolean) : AuthIntent
    data object SubmitLogin : AuthIntent
    data object GoogleLoginClicked : AuthIntent
    data object ForgotPasswordClicked : AuthIntent
    data object BackClicked : AuthIntent
}

data class AuthState(
    val username: String = "",
    val usernameError: String? = null,
    val password: String = "",
    val passwordError: String? = null,
    val isPasswordVisible: Boolean = false,
    val rememberMe: Boolean = true,
    val isUkrainian: Boolean = true,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val generalMessage: String? = null
)

sealed interface AuthEffect {
    data object NavigateBack : AuthEffect
    data object NavigateToHome : AuthEffect
    data class ShowToast(val message: String) : AuthEffect
}
