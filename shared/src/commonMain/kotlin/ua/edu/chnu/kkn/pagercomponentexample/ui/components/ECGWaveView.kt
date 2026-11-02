package ua.edu.chnu.kkn.pagercomponentexample.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors

@Composable
fun ECGWaveView(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition()
    val pulseProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(2200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        val w = size.width
        val h = size.height

        // Base coordinate points from 320x60 viewBox
        val points = listOf(
            Offset(0f, 35f),
            Offset(35f, 35f),
            Offset(45f, 30f),
            Offset(55f, 40f),
            Offset(65f, 35f),
            Offset(100f, 35f),
            Offset(110f, 12f),
            Offset(122f, 55f),
            Offset(134f, 5f),
            Offset(146f, 45f),
            Offset(156f, 35f),
            Offset(195f, 35f),
            Offset(205f, 28f),
            Offset(215f, 38f),
            Offset(225f, 35f),
            Offset(250f, 35f),
            Offset(260f, 18f),
            Offset(270f, 50f),
            Offset(280f, 8f),
            Offset(292f, 42f),
            Offset(302f, 35f),
            Offset(320f, 35f)
        )

        val scaleX = w / 320f
        val scaleY = h / 60f

        val strokePath = Path().apply {
            moveTo(points[0].x * scaleX, points[0].y * scaleY)
            for (i in 1 until points.size) {
                lineTo(points[i].x * scaleX, points[i].y * scaleY)
            }
        }

        val fillPath = Path().apply {
            moveTo(points[0].x * scaleX, points[0].y * scaleY)
            for (i in 1 until points.size) {
                lineTo(points[i].x * scaleX, points[i].y * scaleY)
            }
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }

        // Draw area fill
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    FitPulseColors.PrimaryContainer.copy(alpha = 0.22f),
                    FitPulseColors.PrimaryContainer.copy(alpha = 0.0f)
                ),
                startY = 0f,
                endY = h
            )
        )

        // Dynamic shimmer gradient for the ECG pulse line
        val waveBrush = Brush.horizontalGradient(
            colors = listOf(
                FitPulseColors.PrimaryFixedDim.copy(alpha = 0.4f),
                FitPulseColors.PrimaryContainer,
                FitPulseColors.SecondaryContainer,
                FitPulseColors.PrimaryContainer,
                FitPulseColors.PrimaryFixedDim.copy(alpha = 0.4f)
            ),
            startX = (pulseProgress * w * 1.5f) - (w * 0.5f),
            endX = (pulseProgress * w * 1.5f) + (w * 0.5f)
        )

        // Draw glowing stroke
        drawPath(
            path = strokePath,
            brush = waveBrush,
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
}
