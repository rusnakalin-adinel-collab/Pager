package ua.edu.chnu.kkn.pagercomponentexample.ui.navigation

import androidx.navigation3.runtime.NavKey

sealed interface AppRoute : NavKey {
    data object Onboarding : AppRoute
    data object Auth : AppRoute
}
