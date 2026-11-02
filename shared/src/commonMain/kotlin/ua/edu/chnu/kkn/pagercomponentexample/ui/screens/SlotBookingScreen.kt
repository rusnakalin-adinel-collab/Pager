package ua.edu.chnu.kkn.pagercomponentexample.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import pagercomponentexample.shared.generated.resources.Res
import pagercomponentexample.shared.generated.resources.avatar_1
import pagercomponentexample.shared.generated.resources.avatar_2
import pagercomponentexample.shared.generated.resources.avatar_3
import pagercomponentexample.shared.generated.resources.trainer_alex
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors
import ua.edu.chnu.kkn.pagercomponentexample.ui.FitPulseIcons
import ua.edu.chnu.kkn.pagercomponentexample.ui.components.PagerIndicator

private data class DayItem(
    val dayUa: String,
    val dayEn: String,
    val date: String
)

@Composable
fun SlotBookingScreen(
    isUkrainian: Boolean,
    onStartWorkoutClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedDayIndex by remember { mutableStateOf(2) } // default "СР 16"
    var isSlotBooked by remember { mutableStateOf(false) }

    val days = remember {
        listOf(
            DayItem("ПН", "MON", "14"),
            DayItem("ВТ", "TUE", "15"),
            DayItem("СР", "WED", "16"),
            DayItem("ЧТ", "THU", "17"),
            DayItem("ПТ", "FRI", "18")
        )
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
        // Day Selection Strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(FitPulseColors.SurfaceContainerLow)
                .padding(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            days.forEachIndexed { index, day ->
                val isSelected = index == selectedDayIndex
                val bgColor by animateColorAsState(
                    if (isSelected) FitPulseColors.PrimaryContainer else FitPulseColors.SurfaceContainerHighest.copy(alpha = 0.35f)
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(bgColor)
                        .clickable { selectedDayIndex = index }
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = if (isUkrainian) day.dayUa else day.dayEn,
                            color = if (isSelected) FitPulseColors.OnPrimaryFixed else FitPulseColors.OnSurfaceVariant,
                            fontSize = 11.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.SemiBold,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            text = day.date,
                            color = if (isSelected) FitPulseColors.OnPrimaryFixed else FitPulseColors.Primary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 22.sp
                        )
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 2.dp)
                                    .size(5.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.OnPrimaryFixed)
                            )
                        } else {
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Featured Live Booking Card
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
                // Card Top: Badges
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // High Intensity Tag
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.SurfaceContainerHigh)
                            .padding(horizontal = 10.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            imageVector = FitPulseIcons.Fire,
                            contentDescription = null,
                            tint = FitPulseColors.SecondaryFixed,
                            modifier = Modifier.size(13.dp)
                        )
                        Text(
                            text = "HIGH INTENSITY",
                            color = FitPulseColors.SecondaryFixed,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 0.5.sp
                        )
                    }

                    // Available spots badge
                    Row(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(FitPulseColors.ErrorContainer.copy(alpha = 0.45f))
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
                                    .background(FitPulseColors.Error.copy(alpha = 0.4f))
                            )
                            Box(
                                modifier = Modifier
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.Error)
                            )
                        }
                        Text(
                            text = if (isUkrainian) "3 МІСЦЯ" else "3 SPOTS",
                            color = FitPulseColors.Error,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            letterSpacing = 0.5.sp
                        )
                    }
                }

                // Trainer Media & Details Bento
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Trainer Avatar + Rating
                    Box(
                        modifier = Modifier
                            .size(width = 82.dp, height = 96.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(FitPulseColors.SurfaceContainerHigh)
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.trainer_alex),
                            contentDescription = "Trainer Alex",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // Rating badge
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(4.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(FitPulseColors.SurfaceContainerLowest.copy(alpha = 0.9f))
                                .padding(horizontal = 4.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            Icon(
                                imageVector = FitPulseIcons.Star,
                                contentDescription = null,
                                tint = FitPulseColors.PrimaryContainer,
                                modifier = Modifier.size(11.dp)
                            )
                            Text(
                                text = "4.9",
                                color = FitPulseColors.Primary,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Session Meta
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = FitPulseIcons.Schedule,
                                contentDescription = null,
                                tint = FitPulseColors.SecondaryContainer,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = if (isUkrainian) "18:30 • 55 хв" else "18:30 • 55 min",
                                color = FitPulseColors.OnSurfaceVariant,
                                fontSize = 11.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }

                        Text(
                            text = "CrossFit WOD",
                            color = FitPulseColors.Primary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = (-0.5).sp
                        )

                        Text(
                            text = if (isUkrainian) "Тренер Олексій М." else "Trainer Alex M.",
                            color = FitPulseColors.OnSurfaceVariant,
                            fontSize = 12.sp
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        // Capacity Bar
                        Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (isUkrainian) "Заповненість" else "Occupancy",
                                    color = FitPulseColors.OnSurfaceVariant,
                                    fontSize = 10.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = "88%",
                                    color = FitPulseColors.SecondaryFixed,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(5.dp)
                                    .clip(CircleShape)
                                    .background(FitPulseColors.SurfaceContainerHighest)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth(0.88f)
                                        .height(5.dp)
                                        .clip(CircleShape)
                                        .background(FitPulseColors.PrimaryContainer)
                                )
                            }
                        }
                    }
                }

                // Bottom row: Avatars + Booking Toggle CTA
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Overlapping avatars
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, FitPulseColors.SurfaceContainer, CircleShape)
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.avatar_1),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Box(
                            modifier = Modifier
                                .offset(x = (-8).dp)
                                .size(28.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, FitPulseColors.SurfaceContainer, CircleShape)
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.avatar_2),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Box(
                            modifier = Modifier
                                .offset(x = (-16).dp)
                                .size(28.dp)
                                .clip(CircleShape)
                                .border(1.5.dp, FitPulseColors.SurfaceContainer, CircleShape)
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.avatar_3),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Text(
                            text = if (isUkrainian) "+18 у групі" else "+18 in group",
                            color = FitPulseColors.OnSurfaceVariant,
                            fontSize = 11.sp,
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier.offset(x = (-10).dp)
                        )
                    }

                    // Interactive Book Slot Button
                    val buttonBg by animateColorAsState(
                        if (isSlotBooked) FitPulseColors.PrimaryContainer else FitPulseColors.SurfaceContainerHighest
                    )
                    val buttonTextColor by animateColorAsState(
                        if (isSlotBooked) FitPulseColors.OnPrimaryFixed else FitPulseColors.SecondaryContainer
                    )

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(buttonBg)
                            .clickable { isSlotBooked = !isSlotBooked }
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = if (isSlotBooked) FitPulseIcons.Check else FitPulseIcons.TouchApp,
                                contentDescription = null,
                                tint = buttonTextColor,
                                modifier = Modifier.size(15.dp)
                            )
                            Text(
                                text = if (isSlotBooked) {
                                    if (isUkrainian) "ГОТОВО" else "BOOKED"
                                } else {
                                    if (isUkrainian) "ОБРАТИ" else "SELECT"
                                },
                                color = buttonTextColor,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace,
                                letterSpacing = 0.5.sp
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Chip: Quick booking
            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(FitPulseColors.SurfaceContainerHigh)
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    imageVector = FitPulseIcons.Bolt,
                    contentDescription = null,
                    tint = FitPulseColors.PrimaryContainer,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = if (isUkrainian) "ШВИДКИЙ ЗАПИС" else "QUICK BOOKING",
                    color = FitPulseColors.PrimaryContainer,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 1.sp
                )
            }

            Text(
                text = if (isUkrainian) "Бронюй слоти за секунди" else "Book Slots in Seconds",
                color = FitPulseColors.Primary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )

            Text(
                text = if (isUkrainian)
                    "Обирай улюблених тренерів, записуйся на групові програми та тренуйся у зручний для тебе час."
                else
                    "Choose favorite coaches, sign up for group programs, and train at your most convenient time.",
                color = FitPulseColors.OnSurfaceVariant,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                lineHeight = 19.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Pager Indicator
        PagerIndicator(
            pageCount = 3,
            currentPage = 2,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Main Kinetic CTA: Start Training
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .clip(CircleShape)
                .background(FitPulseColors.PrimaryContainer)
                .clickable { onStartWorkoutClick() },
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = FitPulseIcons.Bolt,
                    contentDescription = null,
                    tint = FitPulseColors.OnPrimaryFixed,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = if (isUkrainian) "Розпочати тренування" else "Start Training",
                    color = FitPulseColors.OnPrimaryFixed,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Login Link
        Row(
            modifier = Modifier
                .clickable { onLoginClick() }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (isUkrainian) "Вже маєш акаунт? " else "Already have an account? ",
                color = FitPulseColors.OnSurfaceVariant,
                fontSize = 13.sp
            )
            Text(
                text = if (isUkrainian) "Увійти" else "Log In",
                color = FitPulseColors.SecondaryFixed,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}
