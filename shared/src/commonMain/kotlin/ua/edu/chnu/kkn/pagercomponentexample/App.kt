package ua.edu.chnu.kkn.pagercomponentexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel
import ua.edu.chnu.kkn.pagercomponentexample.di.appModule
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseTheme
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthViewModel
import ua.edu.chnu.kkn.pagercomponentexample.ui.main.MainViewModel
import ua.edu.chnu.kkn.pagercomponentexample.ui.navigation.AppRoute
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingViewModel
import ua.edu.chnu.kkn.pagercomponentexample.ui.screens.LoginScreen
import ua.edu.chnu.kkn.pagercomponentexample.ui.screens.OnboardingScreen

@Composable
@Preview
fun App() {
    KoinApplication(application = { modules(appModule) }) {
        FitPulseTheme {
            val mainViewModel: MainViewModel = koinViewModel()
            val mainState by mainViewModel.state.collectAsState()

            if (!mainState.isReady) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(FitPulseColors.Background)
                )
                return@FitPulseTheme
            }

            val backStack = remember(mainState.initialRoute) {
                mutableStateListOf<NavKey>(mainState.initialRoute)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(FitPulseColors.Background)
                    .systemBarsPadding()
            ) {
                NavDisplay(
                    backStack = backStack,
                    onBack = {
                        if (backStack.size > 1) {
                            backStack.removeAt(backStack.size - 1)
                        }
                    },
                    entryProvider = entryProvider {
                        entry<AppRoute.Onboarding> {
                            val onboardingViewModel: OnboardingViewModel = koinViewModel()
                            OnboardingScreen(
                                viewModel = onboardingViewModel,
                                onNavigateToAuth = {
                                    backStack.clear()
                                    backStack.add(AppRoute.Auth)
                                }
                            )
                        }

                        entry<AppRoute.Auth> {
                            val authViewModel: AuthViewModel = koinViewModel()
                            LoginScreen(
                                viewModel = authViewModel,
                                onNavigateBack = {
                                    backStack.clear()
                                    backStack.add(AppRoute.Onboarding)
                                },
                                onLoginSuccess = {
                                    // Successfully logged in
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}
