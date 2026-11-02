package ua.edu.chnu.kkn.pagercomponentexample.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val FitPulseIcons.Lock: ImageVector by lazy {
    ImageVector.Builder(
        name = "Lock",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(fill = SolidColor(Color.White)) {
            moveTo(18f, 8f)
            horizontalLineToRelative(-1f)
            verticalLineTo(6f)
            curveToRelative(0f, -2.76f, -2.24f, -5f, -5f, -5f)
            reflectiveCurveTo(7f, 3.24f, 7f, 6f)
            verticalLineToRelative(2f)
            horizontalLineTo(6f)
            curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
            verticalLineToRelative(10f)
            curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
            horizontalLineToRelative(12f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            verticalLineTo(10f)
            curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
            close()
            moveTo(9f, 6f)
            curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f)
            reflectiveCurveToRelative(3f, 1.34f, 3f, 3f)
            verticalLineToRelative(2f)
            horizontalLineTo(9f)
            verticalLineTo(6f)
            close()
            moveTo(18f, 20f)
            horizontalLineTo(6f)
            verticalLineTo(10f)
            horizontalLineToRelative(12f)
            verticalLineTo(20f)
            close()
            moveTo(12f, 17f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f)
            reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f)
            reflectiveCurveToRelative(0.9f, 2f, 2f, 2f)
            close()
        }
    }.build()
}

val FitPulseIcons.BadgeId: ImageVector by lazy {
    ImageVector.Builder(
        name = "BadgeId",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.8f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round
        ) {
            moveTo(4f, 7f)
            curveToRelative(0f, -1.1f, 0.9f, -2f, 2f, -2f)
            horizontalLineToRelative(12f)
            curveToRelative(1.1f, 0f, 2f, 0.9f, 2f, 2f)
            verticalLineToRelative(13f)
            curveToRelative(0f, 1.1f, -0.9f, 2f, -2f, 2f)
            horizontalLineTo(6f)
            curveToRelative(-1.1f, 0f, -2f, -0.9f, -2f, -2f)
            close()
            moveTo(9f, 5f)
            verticalLineTo(3f)
            curveToRelative(0f, -0.55f, 0.45f, -1f, 1f, -1f)
            horizontalLineToRelative(4f)
            curveToRelative(0.55f, 0f, 1f, 0.45f, 1f, 1f)
            verticalLineToRelative(2f)
            moveTo(12f, 11f)
            curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
            reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f)
            reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f)
            reflectiveCurveToRelative(0.9f, 2f, 2f, 2f)
            close()
            moveTo(8.5f, 15.5f)
            curveToRelative(0f, -1.38f, 1.57f, -2.5f, 3.5f, -2.5f)
            reflectiveCurveToRelative(3.5f, 1.12f, 3.5f, 2.5f)
            moveTo(8f, 18.5f)
            horizontalLineToRelative(8f)
        }
    }.build()
}

val FitPulseIcons.Visibility: ImageVector by lazy {
    ImageVector.Builder(
        name = "Visibility",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.8f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round
        ) {
            moveTo(2f, 12f)
            curveToRelative(2.5f, -5f, 6.5f, -7.5f, 10f, -7.5f)
            reflectiveCurveToRelative(7.5f, 2.5f, 10f, 7.5f)
            curveToRelative(-2.5f, 5f, -6.5f, 7.5f, -10f, 7.5f)
            reflectiveCurveTo(4.5f, 17f, 2f, 12f)
            close()
            moveTo(12f, 15f)
            curveToRelative(1.66f, 0f, 3f, -1.34f, 3f, -3f)
            reflectiveCurveToRelative(-1.34f, -3f, -3f, -3f)
            reflectiveCurveToRelative(-3f, 1.34f, -3f, 3f)
            reflectiveCurveToRelative(1.34f, 3f, 3f, 3f)
            close()
        }
    }.build()
}

val FitPulseIcons.VisibilityOff: ImageVector by lazy {
    ImageVector.Builder(
        name = "VisibilityOff",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        path(
            stroke = SolidColor(Color.White),
            strokeLineWidth = 1.8f,
            strokeLineCap = StrokeCap.Round,
            strokeLineJoin = StrokeJoin.Round
        ) {
            moveTo(3f, 3f)
            lineToRelative(18f, 18f)
            moveTo(10.58f, 10.58f)
            curveToRelative(-0.36f, 0.42f, -0.58f, 0.97f, -0.58f, 1.42f)
            curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
            curveToRelative(0.45f, 0f, 1f, -0.22f, 1.42f, -0.58f)
            moveTo(17.36f, 17.36f)
            curveTo(15.77f, 18.5f, 13.96f, 19f, 12f, 19f)
            curveToRelative(-3.5f, 0f, -7.5f, -2.5f, -10f, -7f)
            curveToRelative(1.23f, -2.21f, 3.01f, -4.13f, 5.09f, -5.35f)
            moveTo(9.88f, 5.25f)
            curveTo(10.57f, 5.08f, 11.28f, 5f, 12f, 5f)
            curveToRelative(3.5f, 0f, 7.5f, 2.5f, 10f, 7f)
            curveToRelative(-0.84f, 1.51f, -1.95f, 2.92f, -3.27f, 4.07f)
        }
    }.build()
}

val FitPulseIcons.Google: ImageVector by lazy {
    ImageVector.Builder(
        name = "Google",
        defaultWidth = 24.dp,
        defaultHeight = 24.dp,
        viewportWidth = 24f,
        viewportHeight = 24f
    ).apply {
        // Blue
        path(fill = SolidColor(Color(0xFF4285F4))) {
            moveTo(23.745f, 12.27f)
            curveToRelative(0f, -0.7f, -0.06f, -1.4f, -0.19f, -2.07f)
            horizontalLineTo(12f)
            verticalLineToRelative(4.51f)
            horizontalLineToRelative(6.6f)
            curveToRelative(-0.29f, 1.52f, -1.14f, 2.82f, -2.4f, 3.68f)
            verticalLineToRelative(3.05f)
            horizontalLineToRelative(3.88f)
            curveToRelative(2.27f, -2.09f, 3.665f, -5.17f, 3.665f, -9.17f)
            close()
        }
        // Green
        path(fill = SolidColor(Color(0xFF34A853))) {
            moveTo(12f, 24f)
            curveToRelative(3.24f, 0f, 5.95f, -1.08f, 7.93f, -2.91f)
            lineToRelative(-3.88f, -3.05f)
            curveToRelative(-1.08f, 0.72f, -2.45f, 1.16f, -4.05f, 1.16f)
            curveToRelative(-3.12f, 0f, -5.77f, -2.1f, -6.72f, -4.93f)
            horizontalLineTo(1.25f)
            verticalLineToRelative(3.15f)
            curveTo(3.26f, 21.36f, 7.33f, 24f, 12f, 24f)
            close()
        }
        // Yellow
        path(fill = SolidColor(Color(0xFFFBBC05))) {
            moveTo(5.28f, 14.27f)
            curveToRelative(-0.25f, -0.72f, -0.38f, -1.49f, -0.38f, -2.27f)
            reflectiveCurveToRelative(0.14f, -1.55f, 0.38f, -2.27f)
            verticalLineTo(6.58f)
            horizontalLineTo(1.25f)
            curveTo(0.45f, 8.18f, 0f, 9.99f, 0f, 12f)
            reflectiveCurveToRelative(0.45f, 3.82f, 1.25f, 5.42f)
            lineToRelative(4.03f, -3.15f)
            close()
        }
        // Red
        path(fill = SolidColor(Color(0xFFEA4335))) {
            moveTo(12f, 4.75f)
            curveToRelative(1.77f, 0f, 3.35f, 0.61f, 4.6f, 1.8f)
            lineToRelative(3.42f, -3.42f)
            curveTo(17.95f, 1.19f, 15.24f, 0f, 12f, 0f)
            curveTo(7.33f, 0f, 3.26f, 2.64f, 1.25f, 6.58f)
            lineToRelative(4.03f, 3.15f)
            curveToRelative(0.95f, -2.83f, 3.6f, -4.98f, 6.72f, -4.98f)
            close()
        }
    }.build()
}
