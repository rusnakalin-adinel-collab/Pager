package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.FitPulseIcons
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.PagerIndicator
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.QRMatrixView

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AccessPassScreen(
    isUkrainian: Boolean,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
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
        // Stage Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(FitPulseColors.SurfaceContainerLow)
                .padding(14.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Live Telemetry Mini Bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
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
                            text = if (isUkrainian) "NFC & BLE АКТИВНІ" else "NFC & BLE ACTIVE",
                            color = FitPulseColors.PrimaryContainer,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.8f))
                            .padding(horizontal = 10.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.Sensors,
                            contentDescription = null,
                            tint = FitPulseColors.Secondary,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "GATE-04 SYNC",
                            color = FitPulseColors.Secondary,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 1.sp
                        )
                    }
                }

                // Digital Club Access Pass Card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    FitPulseColors.SurfaceContainerHigh.copy(alpha = 0.95f),
                                    FitPulseColors.SurfaceContainer.copy(alpha = 0.98f)
                                )
                            )
                        )
                        .padding(14.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Card Top: Brand + ID + Contactless Icon
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text(
                                        text = "FITPULSE",
                                        color = FitPulseColors.Primary,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = (-0.5).sp
                                    )
                                    Box(
                                        modifier = Modifier
                                            .clip(CircleShape)
                                            .background(FitPulseColors.PrimaryContainer)
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text(
                                            text = "PRO",
                                            color = FitPulseColors.OnPrimary,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                                Text(
                                    text = "ID: #8942-KYIV-ELITE",
                                    color = FitPulseColors.OnSurfaceVariant,
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace,
                                    letterSpacing = 0.5.sp
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.SurfaceContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.Contactless,
                                    contentDescription = null,
                                    tint = FitPulseColors.SecondaryFixed,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }

                        // Central QR Matrix
                        QRMatrixView()

                        Text(
                            text = if (isUkrainian) "ОНОВЛЕННЯ КОДУ КОЖНІ 25 СЕК" else "CODE REFRESH EVERY 25 SEC",
                            color = FitPulseColors.OnSurfaceVariant,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 0.8.sp
                        )

                        // Locker assigned bar
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.LockOpen,
                                    contentDescription = null,
                                    tint = FitPulseColors.PrimaryContainer,
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = if (isUkrainian) "Шафка #114 закріплена" else "Locker #114 assigned",
                                    color = FitPulseColors.OnSurface,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(FitPulseColors.SurfaceContainerHighest)
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = if (isUkrainian) "Зона А" else "Zone A",
                                    color = FitPulseColors.SecondaryFixed,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }
                }

                // Live Facility Telemetry Widgets Strip (3 cards)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Gym Capacity
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(FitPulseColors.SurfaceContainer)
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.Dumbbell,
                                    contentDescription = null,
                                    tint = FitPulseColors.PrimaryContainer,
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = "42%",
                                    color = FitPulseColors.PrimaryContainer,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Text(
                                text = if (isUkrainian) "Тренажери" else "Gym",
                                color = FitPulseColors.OnSurface,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            // Progress bar
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(4.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.SurfaceContainerHighest)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.42f)
                                        .height(4.dp)
                                        .clip(CircleShape)
                                        .background(FitPulseColors.PrimaryContainer)
                                )
                            }
                        }
                    }

                    // Pool Status
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(FitPulseColors.SurfaceContainer)
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.Pool,
                                    contentDescription = null,
                                    tint = FitPulseColors.SecondaryContainer,
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = if (isUkrainian) "ВІЛЬНО" else "FREE",
                                    color = FitPulseColors.SecondaryContainer,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            Text(
                                text = if (isUkrainian) "Басейн" else "Pool",
                                color = FitPulseColors.OnSurface,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = if (isUkrainian) "27.5°C вода" else "27.5°C water",
                                color = FitPulseColors.OnSurfaceVariant,
                                fontSize = 10.sp
                            )
                        }
                    }

                    // SPA Status
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(FitPulseColors.SurfaceContainer)
                            .padding(10.dp)
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = FitPulseIcons.Spa,
                                    contentDescription = null,
                                    tint = FitPulseColors.TertiaryContainer,
                                    modifier = Modifier.size(15.dp)
                                )
                                Text(
                                    text = if (isUkrainian) "ВІДКРИТО" else "OPEN",
                                    color = FitPulseColors.Primary,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            Text(
                                text = if (isUkrainian) "SPA-зона" else "SPA Area",
                                color = FitPulseColors.OnSurface,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = if (isUkrainian) "Сауни / Хамам" else "Sauna / Hammam",
                                color = FitPulseColors.OnSurfaceVariant,
                                fontSize = 9.sp,
                                maxLines = 1
                            )
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
            Text(
                text = if (isUkrainian) "КРОК 02 / ТЕХНОЛОГІЇ ДОСТУПУ" else "STEP 02 / ACCESS TECH",
                color = FitPulseColors.PrimaryContainer,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 1.sp
            )

            Text(
                text = if (isUkrainian) "Миттєвий вхід за QR-кодом" else "Instant QR Code Entry",
                color = FitPulseColors.Primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 30.sp
            )

            Text(
                text = if (isUkrainian)
                    "Забудь про пластикові картки. Турнікети комплексу, розумні шафки та спа-зони відкриваються в один дотик через додаток."
                else
                    "Forget plastic cards. Complex turnstiles, smart lockers, and spa areas open in a single tap via the app.",
                color = FitPulseColors.OnSurfaceVariant,
                fontSize = 13.sp,
                lineHeight = 19.sp
            )

            // Feature Matrix Pills
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Chip 1
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(FitPulseColors.SurfaceContainer)
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = FitPulseIcons.WifiTethering,
                        contentDescription = null,
                        tint = FitPulseColors.SecondaryContainer,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = "NFC Smart Pass",
                        color = FitPulseColors.OnSurface,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Chip 2
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(FitPulseColors.SurfaceContainer)
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = FitPulseIcons.MeetingRoom,
                        contentDescription = null,
                        tint = FitPulseColors.PrimaryContainer,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = if (isUkrainian) "Автопідбір шафки" else "Smart Locker Match",
                        color = FitPulseColors.OnSurface,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Chip 3
                Row(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(FitPulseColors.SurfaceContainer)
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = FitPulseIcons.Speedometer,
                        contentDescription = null,
                        tint = FitPulseColors.OnSurfaceVariant,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = if (isUkrainian) "0.2с відгук" else "0.2s response",
                        color = FitPulseColors.OnSurface,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Pager Indicator
        PagerIndicator(
            pageCount = 3,
            currentPage = 1,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Action Buttons Row: Back + Next
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back Button
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(CircleShape)
                    .background(FitPulseColors.SurfaceContainerHigh)
                    .clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = FitPulseIcons.ArrowBack,
                    contentDescription = "Back",
                    tint = FitPulseColors.OnSurface,
                    modifier = Modifier.size(20.dp)
                )
            }

            // Next Button
            Box(
                modifier = Modifier
                    .weight(1f)
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
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
