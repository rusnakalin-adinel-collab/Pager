package ua.edu.chnu.kkn.pagercomponentexample.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors

@Composable
fun QRMatrixView(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val laserProgress by infiniteTransition.animateFloat(
        initialValue = 0.08f,
        targetValue = 0.92f,
        animationSpec = infiniteRepeatable(
            animation = tween(2200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
            .size(170.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(FitPulseColors.SurfaceContainerLowest)
            .padding(14.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val scale = size.width / 120f
            val cornerRadius = CornerRadius(3.dp.toPx(), 3.dp.toPx())

            // Corner Finder 1: Top-Left
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(8f * scale, 8f * scale),
                size = Size(30f * scale, 30f * scale),
                cornerRadius = cornerRadius
            )
            drawRoundRect(
                color = FitPulseColors.SurfaceContainerLowest,
                topLeft = Offset(13f * scale, 13f * scale),
                size = Size(20f * scale, 20f * scale),
                cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
            )
            drawRoundRect(
                color = FitPulseColors.PrimaryContainer,
                topLeft = Offset(18f * scale, 18f * scale),
                size = Size(10f * scale, 10f * scale),
                cornerRadius = CornerRadius(1.dp.toPx(), 1.dp.toPx())
            )

            // Corner Finder 2: Top-Right
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(82f * scale, 8f * scale),
                size = Size(30f * scale, 30f * scale),
                cornerRadius = cornerRadius
            )
            drawRoundRect(
                color = FitPulseColors.SurfaceContainerLowest,
                topLeft = Offset(87f * scale, 13f * scale),
                size = Size(20f * scale, 20f * scale),
                cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
            )
            drawRoundRect(
                color = FitPulseColors.PrimaryContainer,
                topLeft = Offset(92f * scale, 18f * scale),
                size = Size(10f * scale, 10f * scale),
                cornerRadius = CornerRadius(1.dp.toPx(), 1.dp.toPx())
            )

            // Corner Finder 3: Bottom-Left
            drawRoundRect(
                color = Color.White,
                topLeft = Offset(8f * scale, 82f * scale),
                size = Size(30f * scale, 30f * scale),
                cornerRadius = cornerRadius
            )
            drawRoundRect(
                color = FitPulseColors.SurfaceContainerLowest,
                topLeft = Offset(13f * scale, 87f * scale),
                size = Size(20f * scale, 20f * scale),
                cornerRadius = CornerRadius(2.dp.toPx(), 2.dp.toPx())
            )
            drawRoundRect(
                color = FitPulseColors.PrimaryContainer,
                topLeft = Offset(18f * scale, 92f * scale),
                size = Size(10f * scale, 10f * scale),
                cornerRadius = CornerRadius(1.dp.toPx(), 1.dp.toPx())
            )

            // Dynamic Data Grid Dots
            fun drawDot(x: Float, y: Float, w: Float = 6f, h: Float = 6f, color: Color = Color.White) {
                drawRoundRect(
                    color = color,
                    topLeft = Offset(x * scale, y * scale),
                    size = Size(w * scale, h * scale),
                    cornerRadius = CornerRadius(1.dp.toPx(), 1.dp.toPx())
                )
            }

            val cyan = FitPulseColors.SecondaryContainer
            val lime = FitPulseColors.PrimaryContainer

            drawDot(44f, 10f)
            drawDot(54f, 10f)
            drawDot(68f, 10f, color = cyan)
            drawDot(44f, 22f)
            drawDot(60f, 22f)
            drawDot(48f, 32f)
            drawDot(64f, 34f, color = cyan)

            drawDot(12f, 46f)
            drawDot(24f, 46f)
            drawDot(34f, 46f)
            drawDot(48f, 46f, 10f, 10f, color = lime)
            drawDot(66f, 46f)
            drawDot(80f, 46f)
            drawDot(94f, 46f)

            drawDot(12f, 58f)
            drawDot(28f, 58f)
            drawDot(42f, 60f)
            drawDot(56f, 60f, 8f, 8f)
            drawDot(74f, 58f, color = cyan)
            drawDot(86f, 58f)
            drawDot(98f, 58f)

            drawDot(12f, 70f)
            drawDot(30f, 70f)
            drawDot(44f, 74f)
            drawDot(62f, 72f)
            drawDot(82f, 70f)
            drawDot(94f, 72f)

            drawDot(46f, 86f)
            drawDot(58f, 86f)
            drawDot(70f, 86f)
            drawDot(84f, 84f, color = cyan)
            drawDot(98f, 84f)

            drawDot(46f, 98f)
            drawDot(60f, 98f)
            drawDot(74f, 96f, 8f, 8f, color = lime)
            drawDot(92f, 98f)

            // Animated Laser Scanner Line
            val laserY = size.height * laserProgress
            drawRect(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Transparent,
                        cyan.copy(alpha = 0.85f),
                        Color.Transparent
                    )
                ),
                topLeft = Offset(0f, laserY - 1.5.dp.toPx()),
                size = Size(size.width, 3.dp.toPx())
            )
        }
    }
}
