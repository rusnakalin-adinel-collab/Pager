package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowWidthSizeClass
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.HeaderBar
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.PagerIndicator
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingEffect
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingIntent
import ua.edu.chnu.kkn.pagercomponentexample.ui.onboarding.OnboardingState
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

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (page != state.currentPage) {
                viewModel.processIntent(OnboardingIntent.PageChanged(page))
            }
        }
    }

    // WindowSizeClass для адаптивної розмітки
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val widthClass = windowSizeClass.windowWidthSizeClass
    val isExpanded = widthClass == WindowWidthSizeClass.EXPANDED
    val isMedium = widthClass == WindowWidthSizeClass.MEDIUM

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(FitPulseColors.Background)
    ) {
        when {
            // Expanded (планшет горизонтально ≥840dp, десктоп): двоколонковий layout
            isExpanded -> OnboardingExpandedLayout(
                state = state,
                pagerState = pagerState,
                viewModel = viewModel
            )

            // Medium (планшет вертикально / телефон горизонтально ≥600dp): центрований контент
            isMedium -> OnboardingMediumLayout(
                state = state,
                pagerState = pagerState,
                viewModel = viewModel
            )

            // Compact (телефон вертикально < 600dp): повноекранний layout
            else -> OnboardingCompactLayout(
                state = state,
                pagerState = pagerState,
                viewModel = viewModel
            )
        }
    }
}

// ─────────────────────────────────────────────────────────
// Compact Layout — один стовпець, повна ширина (< 600dp)
// ─────────────────────────────────────────────────────────
@Composable
private fun OnboardingCompactLayout(
    state: OnboardingState,
    pagerState: PagerState,
    viewModel: OnboardingViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderBar(
            isUkrainian = state.isUkrainian,
            onLanguageToggle = { viewModel.processIntent(OnboardingIntent.LanguageToggled(it)) },
            onSkip = { viewModel.processIntent(OnboardingIntent.SkipClicked) }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) { page ->
            OnboardingPageContent(page = page, state = state, viewModel = viewModel)
        }
    }
}

// ─────────────────────────────────────────────────────────
// Medium Layout — контент обмежений 600dp по центру (600–840dp)
// ─────────────────────────────────────────────────────────
@Composable
private fun OnboardingMediumLayout(
    state: OnboardingState,
    pagerState: PagerState,
    viewModel: OnboardingViewModel
) {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderBar(
            isUkrainian = state.isUkrainian,
            onLanguageToggle = { viewModel.processIntent(OnboardingIntent.LanguageToggled(it)) },
            onSkip = { viewModel.processIntent(OnboardingIntent.SkipClicked) }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.TopCenter
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .width(600.dp)
                    .fillMaxHeight()
            ) { page ->
                OnboardingPageContent(page = page, state = state, viewModel = viewModel)
            }
        }
    }
}

// ─────────────────────────────────────────────────────────
// Expanded Layout — два стовпці: ліворуч бренд, праворуч пейджер (≥ 840dp)
// ─────────────────────────────────────────────────────────
@Composable
private fun OnboardingExpandedLayout(
    state: OnboardingState,
    pagerState: PagerState,
    viewModel: OnboardingViewModel
) {
    Row(modifier = Modifier.fillMaxSize()) {
        // ═══ Ліва колонка: бренд-панель (40%) ═══
        OnboardingBrandPanel(
            isUkrainian = state.isUkrainian,
            currentPage = state.currentPage,
            totalPages = state.totalPages,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.4f)
        )

        // Вертикальний роздільник
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.4f))
        )

        // ═══ Права колонка: HeaderBar + вертикальний пейджер (60%) ═══
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.6f)
        ) {
            HeaderBar(
                isUkrainian = state.isUkrainian,
                onLanguageToggle = { viewModel.processIntent(OnboardingIntent.LanguageToggled(it)) },
                onSkip = { viewModel.processIntent(OnboardingIntent.SkipClicked) }
            )

            VerticalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                userScrollEnabled = false
            ) { page ->
                OnboardingPageContent(page = page, state = state, viewModel = viewModel)
            }
        }
    }
}

// ─────────────────────────────────────────────────────────
// Бренд-панель (ліва частина Expanded layout)
// ─────────────────────────────────────────────────────────
@Composable
private fun OnboardingBrandPanel(
    isUkrainian: Boolean,
    currentPage: Int,
    totalPages: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        FitPulseColors.SurfaceContainerLowest,
                        FitPulseColors.SurfaceContainer,
                        FitPulseColors.SurfaceContainerHigh
                    )
                )
            )
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Логотип
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(FitPulseColors.SurfaceContainerHighest, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(FitPulseColors.PrimaryContainer, CircleShape)
                )
            }

            Spacer(Modifier.width(12.dp))

            Column {
                Row {
                    Text(
                        text = "FIT",
                        color = FitPulseColors.PrimaryContainer,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "PULSE",
                        color = FitPulseColors.TextPrimary,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 2.sp
                    )
                }
                Text(
                    text = if (isUkrainian) "Твій фітнес-асистент" else "Your fitness assistant",
                    color = FitPulseColors.TextSecondary,
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        Spacer(Modifier.height(40.dp))

        // Поточний крок онбордінгу
        val stepTitle = when (currentPage) {
            0 -> if (isUkrainian) "Крок 1 з 3" else "Step 1 of 3"
            1 -> if (isUkrainian) "Крок 2 з 3" else "Step 2 of 3"
            2 -> if (isUkrainian) "Крок 3 з 3" else "Step 3 of 3"
            else -> ""
        }
        val stepDesc = when (currentPage) {
            0 -> if (isUkrainian) "Пульсометрія та телеметрія" else "Pulse metrics & telemetry"
            1 -> if (isUkrainian) "Цифровий абонемент" else "Digital membership pass"
            2 -> if (isUkrainian) "Розклад занять" else "Class schedule & booking"
            else -> ""
        }

        Text(
            text = stepTitle,
            color = FitPulseColors.PrimaryContainer,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 1.sp
        )

        Spacer(Modifier.height(8.dp))

        Text(
            text = stepDesc,
            color = FitPulseColors.TextPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp
        )

        Spacer(Modifier.height(32.dp))

        // Вертикальний індикатор сторінок
        PagerIndicator(
            pageCount = totalPages,
            currentPage = currentPage,
            isVertical = true
        )
    }
}

// ─────────────────────────────────────────────────────────
// Контент окремої сторінки онбордінгу
// ─────────────────────────────────────────────────────────
@Composable
private fun OnboardingPageContent(
    page: Int,
    state: OnboardingState,
    viewModel: OnboardingViewModel
) {
    when (page) {
        0 -> PulseTelemetryScreen(
            isUkrainian = state.isUkrainian,
            onNextClick = { viewModel.processIntent(OnboardingIntent.NextClicked) }
        )
        1 -> AccessPassScreen(
            isUkrainian = state.isUkrainian,
            onBackClick = { viewModel.processIntent(OnboardingIntent.BackClicked) },
            onNextClick = { viewModel.processIntent(OnboardingIntent.NextClicked) }
        )
        2 -> SlotBookingScreen(
            isUkrainian = state.isUkrainian,
            onStartWorkoutClick = { viewModel.processIntent(OnboardingIntent.CompleteClicked) },
            onLoginClick = { viewModel.processIntent(OnboardingIntent.CompleteClicked) }
        )
    }
}
