package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.BadgeId
import ua.edu.chnu.kkn.pagercomponentexample.ui.FitPulseIcons
import ua.edu.chnu.kkn.pagercomponentexample.ui.Google
import ua.edu.chnu.kkn.pagercomponentexample.ui.Lock
import ua.edu.chnu.kkn.pagercomponentexample.ui.Visibility
import ua.edu.chnu.kkn.pagercomponentexample.ui.VisibilityOff
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthEffect
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthIntent
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthState
import ua.edu.chnu.kkn.pagercomponentexample.ui.auth.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onNavigateBack: () -> Unit = {},
    onLoginSuccess: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    var toastMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AuthEffect.NavigateBack -> onNavigateBack()
                is AuthEffect.NavigateToHome -> onLoginSuccess()
                is AuthEffect.ShowToast -> {
                    toastMessage = effect.message
                }
            }
        }
    }

    LaunchedEffect(toastMessage) {
        if (toastMessage != null) {
            delay(3000)
            toastMessage = null
        }
    }

    LoginScreenContent(
        state = state,
        onIntent = viewModel::processIntent,
        toastMessage = toastMessage,
        modifier = modifier
    )
}

@Composable
fun LoginScreenContent(
    state: AuthState,
    onIntent: (AuthIntent) -> Unit,
    toastMessage: String? = null,
    modifier: Modifier = Modifier
) {
    val isUkrainian = state.isUkrainian
    val focusManager = LocalFocusManager.current
    val passwordFocusRequester = remember { FocusRequester() }

    var isLoginFocused by remember { mutableStateOf(false) }
    var isPasswordFocused by remember { mutableStateOf(false) }

    val infiniteTransition = rememberInfiniteTransition()
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.35f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(modifier = modifier.fillMaxSize().background(FitPulseColors.Background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Navigation Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Circular Back Button
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(FitPulseColors.SurfaceContainerHigh)
                        .clickable { onIntent(AuthIntent.BackClicked) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = FitPulseIcons.ArrowBack,
                        contentDescription = if (isUkrainian) "Назад" else "Back",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // FitPulse Center Brand
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerHighest),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(FitPulseColors.PrimaryContainer)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Row {
                        Text(
                            text = "FIT",
                            color = FitPulseColors.PrimaryContainer,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "PULSE",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                    }
                }

                // Language Toggle Pill UA / EN
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(FitPulseColors.SurfaceContainerLowest)
                        .padding(3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(if (isUkrainian) FitPulseColors.SurfaceContainerHigh else Color.Transparent)
                            .clickable { onIntent(AuthIntent.ToggleLanguage(true)) }
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "UA",
                            color = if (isUkrainian) Color.White else FitPulseColors.TextSecondary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(if (!isUkrainian) FitPulseColors.SurfaceContainerHigh else Color.Transparent)
                            .clickable { onIntent(AuthIntent.ToggleLanguage(false)) }
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "EN",
                            color = if (!isUkrainian) Color.White else FitPulseColors.TextSecondary,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Hero Security Protocol Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(FitPulseColors.SurfaceCard)
                    .border(
                        BorderStroke(1.dp, FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.5f)),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Top Security Badge
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerHigh)
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.Lock,
                            contentDescription = null,
                            tint = FitPulseColors.PrimaryContainer,
                            modifier = Modifier.size(13.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isUkrainian) "БЕЗПЕЧНИЙ ВХІД • PROTOCOL V2.4" else "SECURE LOGIN • PROTOCOL V2.4",
                            color = FitPulseColors.TextPrimary,
                            fontSize = 10.5.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 0.8.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Title: Вхід до кабінету атлета
                    Row {
                        Text(
                            text = if (isUkrainian) "Вхід до кабінету " else "Athlete cabinet ",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (isUkrainian) "атлета" else "login",
                            color = FitPulseColors.PrimaryContainer,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Subtitle
                    Text(
                        text = if (isUkrainian) {
                            "Увійдіть для миттєвого доступу до абонемента, персонального розкладу та живої телеметрії комплексу."
                        } else {
                            "Log in for instant access to your membership, personal schedule, and live telemetry of the complex."
                        },
                        color = FitPulseColors.TextSecondary,
                        fontSize = 13.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Bottom Status Row (Turnstile Pass & Zona A)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(9.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.PrimaryContainer)
                                    .alpha(pulseAlpha)
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "TURNSTILE PASS: ACTIVE",
                                color = FitPulseColors.TextPrimary,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 0.5.sp
                            )
                        }

                        Text(
                            text = "ZONA A • 68%",
                            color = FitPulseColors.SecondaryContainer,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Field 1: EMAIL / ТЕЛЕФОН / ID АТЛЕТА
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = if (isUkrainian) "EMAIL / ТЕЛЕФОН / ID АТЛЕТА" else "EMAIL / PHONE / ATHLETE ID",
                    color = if (state.usernameError != null) FitPulseColors.Error else FitPulseColors.TextSecondary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                val usernameBorderColor = when {
                    state.usernameError != null -> FitPulseColors.Error
                    isLoginFocused -> FitPulseColors.PrimaryContainer
                    else -> FitPulseColors.SurfaceContainerHighest
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(FitPulseColors.SurfaceContainer)
                        .border(
                            BorderStroke(1.dp, usernameBorderColor),
                            RoundedCornerShape(14.dp)
                        )
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.BadgeId,
                            contentDescription = null,
                            tint = when {
                                state.usernameError != null -> FitPulseColors.Error
                                isLoginFocused -> FitPulseColors.PrimaryContainer
                                else -> FitPulseColors.TextSecondary
                            },
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Box(modifier = Modifier.weight(1f)) {
                            if (state.username.isEmpty()) {
                                Text(
                                    text = if (isUkrainian) "athlete@fitpulse.ua або +380" else "athlete@fitpulse.ua or +380",
                                    color = FitPulseColors.TextTertiary,
                                    fontSize = 14.5.sp
                                )
                            }
                            BasicTextField(
                                value = state.username,
                                onValueChange = { onIntent(AuthIntent.UsernameChanged(it)) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onFocusChanged { isLoginFocused = it.isFocused },
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 14.5.sp,
                                    fontFamily = FontFamily.Default
                                ),
                                singleLine = true,
                                cursorBrush = SolidColor(FitPulseColors.PrimaryContainer),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Email,
                                    imeAction = ImeAction.Next
                                ),
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        passwordFocusRequester.requestFocus()
                                    }
                                )
                            )
                        }
                    }
                }

                // Error validation message
                if (state.usernameError != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = state.usernameError,
                        color = FitPulseColors.Error,
                        fontSize = 11.5.sp,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Field 2: ПАРОЛЬ ДОСТУПУ
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isUkrainian) "ПАРОЛЬ ДОСТУПУ" else "ACCESS PASSWORD",
                        color = if (state.passwordError != null) FitPulseColors.Error else FitPulseColors.TextSecondary,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = if (isUkrainian) "мін. 6 символів" else "min. 6 characters",
                        color = FitPulseColors.TextTertiary,
                        fontSize = 11.sp,
                        fontFamily = FontFamily.Monospace
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                val passwordBorderColor = when {
                    state.passwordError != null -> FitPulseColors.Error
                    isPasswordFocused -> FitPulseColors.PrimaryContainer
                    else -> FitPulseColors.SurfaceContainerHighest
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(FitPulseColors.SurfaceContainer)
                        .border(
                            BorderStroke(1.dp, passwordBorderColor),
                            RoundedCornerShape(14.dp)
                        )
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.Lock,
                            contentDescription = null,
                            tint = when {
                                state.passwordError != null -> FitPulseColors.Error
                                isPasswordFocused -> FitPulseColors.PrimaryContainer
                                else -> FitPulseColors.TextSecondary
                            },
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Box(modifier = Modifier.weight(1f)) {
                            if (state.password.isEmpty()) {
                                Text(
                                    text = "••••••••••••",
                                    color = FitPulseColors.TextTertiary,
                                    fontSize = 16.sp,
                                    letterSpacing = 2.sp
                                )
                            }
                            BasicTextField(
                                value = state.password,
                                onValueChange = { onIntent(AuthIntent.PasswordChanged(it)) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .focusRequester(passwordFocusRequester)
                                    .onFocusChanged { isPasswordFocused = it.isFocused },
                                textStyle = TextStyle(
                                    color = Color.White,
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Default
                                ),
                                singleLine = true,
                                visualTransformation = if (state.isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                cursorBrush = SolidColor(FitPulseColors.PrimaryContainer),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Password,
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()
                                        onIntent(AuthIntent.SubmitLogin)
                                    }
                                )
                            )
                        }

                        IconButton(
                            onClick = { onIntent(AuthIntent.TogglePasswordVisibility) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(
                                imageVector = if (state.isPasswordVisible) FitPulseIcons.VisibilityOff else FitPulseIcons.Visibility,
                                contentDescription = if (state.isPasswordVisible) "Приховати пароль" else "Показати пароль",
                                tint = FitPulseColors.TextSecondary,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                }

                // Error validation message
                if (state.passwordError != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = state.passwordError,
                        color = FitPulseColors.Error,
                        fontSize = 11.5.sp,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Row: Remember me checkbox + Forgot password link
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable { onIntent(AuthIntent.ToggleRememberMe) }
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (state.rememberMe) FitPulseColors.PrimaryContainer else FitPulseColors.SurfaceContainer)
                            .border(
                                BorderStroke(
                                    1.5.dp,
                                    if (state.rememberMe) FitPulseColors.PrimaryContainer else FitPulseColors.Outline
                                ),
                                RoundedCornerShape(6.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (state.rememberMe) {
                            Icon(
                                imageVector = FitPulseIcons.Check,
                                contentDescription = null,
                                tint = FitPulseColors.OnPrimaryFixed,
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = if (isUkrainian) "Запам'ятати мене" else "Remember me",
                        color = FitPulseColors.TextPrimary,
                        fontSize = 13.sp
                    )
                }

                Text(
                    text = if (isUkrainian) "Забули пароль?" else "Forgot password?",
                    color = FitPulseColors.PrimaryContainer,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { onIntent(AuthIntent.ForgotPasswordClicked) }
                        .padding(vertical = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Primary Action: Увійти до системи ➔
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .clip(RoundedCornerShape(27.dp))
                    .background(FitPulseColors.PrimaryContainer)
                    .clickable(enabled = !state.isLoading) {
                        focusManager.clearFocus()
                        onIntent(AuthIntent.SubmitLogin)
                    },
                contentAlignment = Alignment.Center
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        color = FitPulseColors.OnPrimaryFixed,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.5.dp
                    )
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (isUkrainian) "Увійти до системи" else "Sign in to system",
                            color = FitPulseColors.OnPrimaryFixed,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            imageVector = FitPulseIcons.ArrowForward,
                            contentDescription = null,
                            tint = FitPulseColors.OnPrimaryFixed,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(22.dp))

            // Divider: АБО УВІЙТИ ЧЕРЕЗ
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.7f))
                )

                Text(
                    text = if (isUkrainian) "  АБО УВІЙТИ ЧЕРЕЗ  " else "  OR SIGN IN WITH  ",
                    color = FitPulseColors.TextTertiary,
                    fontSize = 10.5.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 1.sp
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.7f))
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Social Button: Продовжити з Google
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(FitPulseColors.SurfaceContainerHigh)
                    .border(
                        BorderStroke(1.dp, FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.6f)),
                        RoundedCornerShape(14.dp)
                    )
                    .clickable { onIntent(AuthIntent.GoogleLoginClicked) },
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = FitPulseIcons.Google,
                        contentDescription = "Google",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = if (isUkrainian) "Продовжити з Google" else "Continue with Google",
                        color = FitPulseColors.TextPrimary,
                        fontSize = 14.5.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Motivational Quote & Core Branding
            Text(
                text = if (isUkrainian) {
                    "«Кожне тренування — це крок до кращої версії себе»"
                } else {
                    "«Every workout is a step toward a better version of yourself»"
                },
                color = Color.White,
                fontSize = 14.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = if (isUkrainian) {
                    "FitPulse Digital Core • Твій особистий прогрес щодня"
                } else {
                    "FitPulse Digital Core • Your personal progress daily"
                },
                color = FitPulseColors.TextTertiary,
                fontSize = 11.sp,
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Bottom SSO Badge
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(FitPulseColors.PrimaryContainer)
                        .alpha(pulseAlpha)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = "SINGLE SIGN-ON • FITPULSE CLOUD CORE API V4",
                    color = FitPulseColors.TextSecondary,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 0.8.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Animated Notification / Toast banner
        AnimatedVisibility(
            visible = toastMessage != null,
            enter = fadeIn() + slideInVertically(initialOffsetY = { -it }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { -it }),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp, start = 20.dp, end = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(FitPulseColors.SurfaceContainerHighest)
                    .border(
                        BorderStroke(1.dp, FitPulseColors.PrimaryContainer),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = toastMessage ?: "",
                    color = FitPulseColors.TextPrimary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Monospace
                )
            }
        }
    }
}
