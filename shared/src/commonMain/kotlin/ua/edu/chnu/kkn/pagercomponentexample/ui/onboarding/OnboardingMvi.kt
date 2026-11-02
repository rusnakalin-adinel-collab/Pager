package ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding

sealed interface OnboardingIntent {
    data class PageChanged(val page: Int) : OnboardingIntent
    data object NextClicked : OnboardingIntent
    data object BackClicked : OnboardingIntent
    data object SkipClicked : OnboardingIntent
    data object CompleteClicked : OnboardingIntent
    data class LanguageToggled(val isUkrainian: Boolean) : OnboardingIntent
}

data class OnboardingState(
    val currentPage: Int = 0,
    val totalPages: Int = 3,
    val isUkrainian: Boolean = true,
    val isCompleted: Boolean = false
)

sealed interface OnboardingEffect {
    data object NavigateToAuth : OnboardingEffect
    data class AnimateToPage(val page: Int) : OnboardingEffect
}
