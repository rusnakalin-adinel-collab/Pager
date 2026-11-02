package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.HeaderBar
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingEffect
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingIntent
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingViewModel

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel,
    onNavigateToAuth: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = state.currentPage,
        pageCount = { state.totalPages }
    )

    // Listen to MVI side effects
    LaunchedEffect(viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is OnboardingEffect.NavigateToAuth -> {
                    onNavigateToAuth()
                }

                is OnboardingEffect.AnimateToPage -> {
                    pagerState.animateScrollToPage(effect.page)
                }
            }
        }
    }

    // Sync pager state back to MVI state
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (page != state.currentPage) {
                viewModel.processIntent(OnboardingIntent.PageChanged(page))
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(FitPulseColors.Background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderBar(
                isUkrainian = state.isUkrainian,
                onLanguageToggle = {
                    viewModel.processIntent(OnboardingIntent.LanguageToggled(it))
                },
                onSkip = {
                    viewModel.processIntent(OnboardingIntent.SkipClicked)
                }
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) { page ->
                when (page) {
                    0 -> PulseTelemetryScreen(
                        isUkrainian = state.isUkrainian,
                        onNextClick = {
                            viewModel.processIntent(OnboardingIntent.NextClicked)
                        }
                    )

                    1 -> AccessPassScreen(
                        isUkrainian = state.isUkrainian,
                        onBackClick = {
                            viewModel.processIntent(OnboardingIntent.BackClicked)
                        },
                        onNextClick = {
                            viewModel.processIntent(OnboardingIntent.NextClicked)
                        }
                    )

                    2 -> SlotBookingScreen(
                        isUkrainian = state.isUkrainian,
                        onStartWorkoutClick = {
                            viewModel.processIntent(OnboardingIntent.CompleteClicked)
                        },
                        onLoginClick = {
                            viewModel.processIntent(OnboardingIntent.CompleteClicked)
                        }
                    )
                }
            }
        }
    }
}
