package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import pagercomponentexample.shared.generated.resources.Res
import pagercomponentexample.shared.generated.resources.runner_silhouette
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.FitPulseIcons
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.ECGWaveView
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.PagerIndicator

@Composable
fun PulseTelemetryScreen(
    isUkrainian: Boolean,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var bpmValue by remember { mutableStateOf(143) }

    // Subtle BPM micro-interaction
    LaunchedEffect(Unit) {
        while (true) {
            delay(2200)
            bpmValue = 140 + (0..6).random()
        }
    }

    val pingScale = remember { Animatable(1f) }
    LaunchedEffect(Unit) {
        pingScale.animateTo(
            targetValue = 1.6f,
            animationSpec = infiniteRepeatable(
                animation = tween(1200, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Hero Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FitPulseColors.SurfaceContainer)
                .padding(14.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Telemetry Ribbon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Live Dot + Label
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerLowest.copy(alpha = 0.85f))
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .scale(pingScale.value)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.PrimaryContainer.copy(alpha = 0.4f))
                            )
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.PrimaryContainer)
                            )
                        }
                        Text(
                            text = "LIVE TELEMETRY",
                            color = FitPulseColors.PrimaryContainer,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                    }

                    // BLE Synced Chip
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerHigh)
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.Sensors,
                            contentDescription = null,
                            tint = FitPulseColors.SecondaryFixed,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "BLE SYNCED",
                            color = FitPulseColors.SecondaryFixed,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                    }
                }

                // Athlete Runner Image + Scrim Overlay
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(FitPulseColors.SurfaceContainerLowest)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.runner_silhouette),
                        contentDescription = "Runner silhouette",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    // Scrim gradient
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        FitPulseColors.SurfaceContainer.copy(alpha = 0.5f),
                                        FitPulseColors.SurfaceContainer.copy(alpha = 0.95f)
                                    ),
                                    startY = 60f
                                )
                            )
                    )

                    // Overlay bottom metrics
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column {
                            Text(
                                text = if (isUkrainian) "ПОТОЧНА ЗОНА" else "CURRENT ZONE",
                                color = FitPulseColors.OnSurfaceVariant,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 0.8.sp
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.Fire,
                                    contentDescription = null,
                                    tint = FitPulseColors.PrimaryContainer,
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = if (isUkrainian) "Зона спалювання жиру" else "Fat burn zone",
                                    color = FitPulseColors.PrimaryContainer,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = if (isUkrainian) "ПІКОВИЙ BPM" else "PEAK BPM",
                                color = FitPulseColors.SecondaryFixed,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "168",
                                color = FitPulseColors.Primary,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 34.sp
                            )
                        }
                    }
                }

                // Heart Rate Visualizer Card
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(FitPulseColors.SurfaceContainerLowest.copy(alpha = 0.9f))
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.Bottom,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "$bpmValue",
                                color = FitPulseColors.Primary,
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 34.sp
                            )
                            Text(
                                text = "BPM",
                                color = FitPulseColors.PrimaryContainer,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(FitPulseColors.SurfaceContainerHigh)
                                .padding(horizontal = 10.dp, vertical = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = FitPulseIcons.Speedometer,
                                contentDescription = null,
                                tint = FitPulseColors.PrimaryContainer,
                                modifier = Modifier.size(13.dp)
                            )
                            Text(
                                text = if (isUkrainian) "НАВАНТАЖЕННЯ 78%" else "LOAD 78%",
                                color = FitPulseColors.OnSurface,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }

                    // Vector ECG Cardio Wave
                    ECGWaveView(modifier = Modifier.padding(vertical = 4.dp))

                    // Quick Telemetry Micro Grid
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Oxygen
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(FitPulseColors.SurfaceContainer)
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = if (isUkrainian) "КИСЕНЬ" else "OXYGEN",
                                    color = FitPulseColors.OnSurfaceVariant,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = "98%",
                                    color = FitPulseColors.Primary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // Calories
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(FitPulseColors.SurfaceContainer)
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = if (isUkrainian) "КАЛОРІЇ" else "CALORIES",
                                    color = FitPulseColors.OnSurfaceVariant,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = if (isUkrainian) "420 ккал" else "420 kcal",
                                    color = FitPulseColors.Primary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        // HRV
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .background(FitPulseColors.SurfaceContainer)
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = if (isUkrainian) "ВАРІАБЕЛЬНІСТЬ" else "HRV",
                                    color = FitPulseColors.OnSurfaceVariant,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Medium,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = if (isUkrainian) "64 мс" else "64 ms",
                                    color = FitPulseColors.PrimaryContainer,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Narrative Section
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Step badge
            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(FitPulseColors.SurfaceContainerHigh)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = FitPulseIcons.VitalSigns,
                    contentDescription = null,
                    tint = FitPulseColors.PrimaryContainer,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = if (isUkrainian) "КРОК 1 З 3: ПУЛЬСОМЕТРІЯ" else "STEP 1 OF 3: PULSE METRICS",
                    color = FitPulseColors.OnSurface,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 0.5.sp
                )
            }

            Text(
                text = if (isUkrainian) "Твій пульс під контролем 24/7" else "Your pulse under control 24/7",
                color = FitPulseColors.Primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )

            Text(
                text = if (isUkrainian)
                    "Синхронізуй смарт-годинники, відстежуй інтенсивність занять та отримуй персональні рекомендації тренувального навантаження."
                else
                    "Sync smartwatches, track workout intensity and receive personal training load recommendations.",
                color = FitPulseColors.OnSurfaceVariant,
                fontSize = 13.sp,
                lineHeight = 19.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Pager Indicator
        PagerIndicator(
            pageCount = 3,
            currentPage = 0,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // CTA Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(CircleShape)
                .background(FitPulseColors.PrimaryContainer)
                .clickable { onNextClick() },
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = if (isUkrainian) "Далі" else "Next",
                    color = FitPulseColors.OnPrimaryFixed,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = FitPulseIcons.ArrowForward,
                    contentDescription = null,
                    tint = FitPulseColors.OnPrimaryFixed,
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
