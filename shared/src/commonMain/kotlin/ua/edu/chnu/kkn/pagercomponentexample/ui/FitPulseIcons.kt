package ua.edu.chnu.kkn.pagercomponentexample.ui

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object FitPulseIcons {
    val Sensors: ImageVector by lazy {
        ImageVector.Builder(
            name = "Sensors",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color.White),
                stroke = null
            ) {
                moveTo(12f, 15f)
                curveToRelative(-1.66f, 0f, -3f, -1.34f, -3f, -3f)
                reflectiveCurveToRelative(1.34f, -3f, 3f, -3f)
                reflectiveCurveToRelative(3f, 1.34f, 3f, 3f)
                reflectiveCurveToRelative(-1.34f, 3f, -3f, 3f)
                close()
                moveTo(4.44f, 4.44f)
                curveTo(2.45f, 6.43f, 1.25f, 9.08f, 1.25f, 12f)
                reflectiveCurveToRelative(1.2f, 5.57f, 3.19f, 7.56f)
                lineToRelative(1.41f, -1.41f)
                curveTo(4.25f, 16.55f, 3.25f, 14.41f, 3.25f, 12f)
                reflectiveCurveToRelative(1f, -4.55f, 2.6f, -6.15f)
                lineTo(4.44f, 4.44f)
                close()
                moveTo(19.56f, 4.44f)
                lineToRelative(-1.41f, 1.41f)
                curveTo(19.75f, 7.45f, 20.75f, 9.59f, 20.75f, 12f)
                reflectiveCurveToRelative(-1f, 4.55f, -2.6f, 6.15f)
                lineToRelative(1.41f, 1.41f)
                curveToRelative(1.99f, -1.99f, 3.19f, -4.64f, 3.19f, -7.56f)
                reflectiveCurveToRelative(-1.2f, -5.57f, -3.19f, -7.56f)
                close()
                moveTo(7.27f, 7.27f)
                curveTo(6.01f, 8.53f, 5.25f, 10.18f, 5.25f, 12f)
                reflectiveCurveToRelative(0.76f, 3.47f, 2.02f, 4.73f)
                lineToRelative(1.41f, -1.41f)
                curveTo(7.79f, 14.43f, 7.25f, 13.28f, 7.25f, 12f)
                reflectiveCurveToRelative(0.54f, -2.43f, 1.43f, -3.32f)
                lineTo(7.27f, 7.27f)
                close()
                moveTo(16.73f, 7.27f)
                lineToRelative(-1.41f, 1.41f)
                curveToRelative(0.89f, 0.89f, 1.43f, 2.04f, 1.43f, 3.32f)
                reflectiveCurveToRelative(-0.54f, 2.43f, -1.43f, 3.32f)
                lineToRelative(1.41f, 1.41f)
                curveToRelative(1.26f, -1.26f, 2.02f, -2.91f, 2.02f, -4.73f)
                reflectiveCurveToRelative(-0.76f, -3.47f, -2.02f, -4.73f)
                close()
            }
        }.build()
    }

    val Fire: ImageVector by lazy {
        ImageVector.Builder(
            name = "Fire",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 2.5f)
                curveTo(10f, 6f, 8f, 8.5f, 8f, 11f)
                curveToRelative(0f, 1.34f, 0.53f, 2.55f, 1.39f, 3.44f)
                curveToRelative(0.24f, -0.68f, 0.65f, -1.33f, 1.25f, -1.84f)
                curveTo(11.23f, 12.11f, 12f, 10.74f, 12f, 9.5f)
                curveToRelative(1.5f, 2.2f, 3.5f, 3.8f, 3.5f, 6.5f)
                curveToRelative(0f, 2.76f, -2.24f, 5f, -5f, 5f)
                curveToRelative(-3.87f, 0f, -7f, -3.13f, -7f, -7f)
                curveToRelative(0f, -3.9f, 2.6f, -7.53f, 6.22f, -8.76f)
                lineTo(12f, 2.5f)
                close()
                moveTo(13.5f, 16f)
                curveToRelative(0f, -1.1f, -0.9f, -2f, -2f, -2f)
                reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f)
                curveToRelative(0f, 1.1f, 0.9f, 2f, 2f, 2f)
                reflectiveCurveToRelative(2f, -0.9f, 2f, -2f)
                close()
            }
        }.build()
    }

    val Speedometer: ImageVector by lazy {
        ImageVector.Builder(
            name = "Speedometer",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 4f)
                curveTo(7.03f, 4f, 3f, 8.03f, 3f, 13f)
                curveToRelative(0f, 2.12f, 0.74f, 4.07f, 1.97f, 5.61f)
                lineTo(4f, 19.59f)
                lineToRelative(1.41f, 1.41f)
                lineToRelative(1.36f, -1.36f)
                curveTo(8.27f, 20.47f, 10.06f, 21f, 12f, 21f)
                reflectiveCurveToRelative(3.73f, -0.53f, 5.23f, -1.36f)
                lineToRelative(1.36f, 1.36f)
                lineToRelative(1.41f, -1.41f)
                lineToRelative(-0.97f, -0.98f)
                curveTo(20.26f, 17.07f, 21f, 15.12f, 21f, 13f)
                curveToRelative(0f, -4.97f, -4.03f, -9f, -9f, -9f)
                close()
                moveTo(12f, 19f)
                curveToRelative(-3.31f, 0f, -6f, -2.69f, -6f, -6f)
                reflectiveCurveToRelative(2.69f, -6f, 6f, -6f)
                reflectiveCurveToRelative(6f, 2.69f, 6f, 6f)
                reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f)
                close()
                moveTo(13.41f, 10.59f)
                lineTo(10.59f, 13.41f)
                curveToRelative(-0.39f, 0.39f, -0.39f, 1.02f, 0f, 1.41f)
                curveToRelative(0.39f, 0.39f, 1.02f, 0.39f, 1.41f, 0f)
                lineToRelative(2.82f, -2.82f)
                curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0f, -1.41f)
                curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0f)
                close()
            }
        }.build()
    }

    val VitalSigns: ImageVector by lazy {
        ImageVector.Builder(
            name = "VitalSigns",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(3f, 12f)
                lineTo(7f, 12f)
                lineTo(9.5f, 6f)
                lineTo(13.5f, 18f)
                lineTo(16f, 10f)
                lineTo(17.5f, 13f)
                lineTo(21f, 13f)
            }
        }.build()
    }

    val Contactless: ImageVector by lazy {
        ImageVector.Builder(
            name = "Contactless",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12f, 2f)
                curveTo(6.48f, 2f, 2f, 6.48f, 2f, 12f)
                reflectiveCurveToRelative(4.48f, 10f, 10f, 10f)
                reflectiveCurveToRelative(10f, -4.48f, 10f, -10f)
                reflectiveCurveTo(17.52f, 2f, 12f, 2f)
                close()
                moveTo(9f, 8.5f)
                curveToRelative(1.93f, 0f, 3.5f, 1.57f, 3.5f, 3.5f)
                reflectiveCurveToRelative(-1.57f, 3.5f, -3.5f, 3.5f)
                moveTo(6.5f, 6f)
                curveToRelative(3.31f, 0f, 6f, 2.69f, 6f, 6f)
                reflectiveCurveToRelative(-2.69f, 6f, -6f, 6f)
            }
        }.build()
    }

    val LockOpen: ImageVector by lazy {
        ImageVector.Builder(
            name = "LockOpen",
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
                horizontalLineToRelative(2f)
                curveToRelative(0f, -1.66f, 1.34f, -3f, 3f, -3f)
                reflectiveCurveToRelative(3f, 1.34f, 3f, 3f)
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
                moveTo(18f, 20f)
                horizontalLineTo(6f)
                verticalLineTo(10f)
                horizontalLineToRelative(12f)
                verticalLineToRelative(10f)
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

    val Dumbbell: ImageVector by lazy {
        ImageVector.Builder(
            name = "Dumbbell",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(20.57f, 14.86f)
                lineTo(22f, 13.43f)
                lineTo(20.57f, 12f)
                lineTo(17f, 15.57f)
                lineTo(8.43f, 7f)
                lineTo(12f, 3.43f)
                lineTo(10.57f, 2f)
                lineTo(9.14f, 3.43f)
                lineTo(7.71f, 2f)
                lineTo(5.57f, 4.14f)
                lineTo(4.14f, 2.71f)
                lineTo(2.71f, 4.14f)
                lineToRelative(1.43f, 1.43f)
                lineTo(2f, 7.71f)
                lineToRelative(1.43f, 1.43f)
                lineTo(2f, 10.57f)
                lineToRelative(1.43f, 1.43f)
                lineTo(7f, 8.43f)
                lineTo(15.57f, 17f)
                lineTo(12f, 20.57f)
                lineTo(13.43f, 22f)
                lineToRelative(1.43f, -1.43f)
                lineTo(16.29f, 22f)
                lineToRelative(2.14f, -2.14f)
                lineToRelative(1.43f, 1.43f)
                lineToRelative(1.43f, -1.43f)
                lineToRelative(-1.43f, -1.43f)
                lineTo(22f, 16.29f)
                lineToRelative(-1.43f, -1.43f)
                close()
            }
        }.build()
    }

    val Pool: ImageVector by lazy {
        ImageVector.Builder(
            name = "Pool",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color.White),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(3f, 17f)
                curveToRelative(2f, 1f, 4f, 1f, 6f, 0f)
                curveToRelative(2f, -1f, 4f, -1f, 6f, 0f)
                curveToRelative(2f, 1f, 4f, 1f, 6f, 0f)
                moveTo(3f, 21f)
                curveToRelative(2f, 1f, 4f, 1f, 6f, 0f)
                curveToRelative(2f, -1f, 4f, -1f, 6f, 0f)
                curveToRelative(2f, 1f, 4f, 1f, 6f, 0f)
            }
            path(fill = SolidColor(Color.White)) {
                moveTo(18.5f, 6f)
                curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f)
                reflectiveCurveToRelative(-2f, 0.9f, -2f, 2f)
                reflectiveCurveToRelative(0.9f, 2f, 2f, 2f)
                close()
                moveTo(7.1f, 10.9f)
                lineToRelative(5.2f, -5.2f)
                curveToRelative(0.6f, -0.6f, 1.4f, -0.9f, 2.2f, -0.9f)
                curveToRelative(1.7f, 0f, 3.1f, 1.4f, 3.1f, 3.1f)
                verticalLineToRelative(3.1f)
                horizontalLineToRelative(-2f)
                verticalLineTo(7.9f)
                lineToRelative(-3.4f, 3.4f)
                lineToRelative(3.9f, 2.3f)
                lineToRelative(-1f, 1.7f)
                lineToRelative(-5.6f, -3.3f)
                lineToRelative(-2.4f, 2.4f)
                lineToRelative(-1.4f, -1.4f)
                lineToRelative(1.4f, -2.1f)
                close()
            }
        }.build()
    }

    val Spa: ImageVector by lazy {
        ImageVector.Builder(
            name = "Spa",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 3f)
                curveToRelative(-1.87f, 2.5f, -3.5f, 5.5f, -3.5f, 8.5f)
                curveToRelative(0f, 2.5f, 1.57f, 4.5f, 3.5f, 4.5f)
                reflectiveCurveToRelative(3.5f, -2f, 3.5f, -4.5f)
                curveTo(15.5f, 8.5f, 13.87f, 5.5f, 12f, 3f)
                close()
                moveTo(5f, 13f)
                curveToRelative(0f, -2.5f, 1.25f, -4.8f, 3f, -6.3f)
                curveToRelative(-0.64f, 1.84f, -0.9f, 3.84f, -0.73f, 5.86f)
                curveTo(5.95f, 13.3f, 5f, 14.54f, 5f, 16f)
                curveToRelative(0f, 2.76f, 2.24f, 5f, 5f, 5f)
                curveToRelative(0.77f, 0f, 1.5f, -0.17f, 2f, -0.49f)
                curveToRelative(-4f, -0.51f, -7f, -3.76f, -7f, -7.51f)
                close()
                moveTo(19f, 13f)
                curveToRelative(0f, 3.75f, -3f, 7f, -7f, 7.51f)
                curveToRelative(0.5f, 0.32f, 1.23f, 0.49f, 2f, 0.49f)
                curveToRelative(2.76f, 0f, 5f, -2.24f, 5f, -5f)
                curveToRelative(0f, -1.46f, -0.95f, -2.7f, -2.27f, -3.44f)
                curveToRelative(0.17f, -2.02f, -0.09f, -4.02f, -0.73f, -5.86f)
                curveToRelative(1.75f, 1.5f, 3f, 3.8f, 3f, 6.3f)
                close()
            }
        }.build()
    }

    val WifiTethering: ImageVector by lazy {
        ImageVector.Builder(
            name = "WifiTethering",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 11f)
                curveToRelative(-1.1f, 0f, -2f, 0.9f, -2f, 2f)
                reflectiveCurveToRelative(0.9f, 2f, 2f, 2f)
                reflectiveCurveToRelative(2f, -0.9f, 2f, -2f)
                reflectiveCurveToRelative(-0.9f, -2f, -2f, -2f)
                close()
                moveTo(12f, 7f)
                curveToRelative(-3.31f, 0f, -6f, 2.69f, -6f, 6f)
                curveToRelative(0f, 1.45f, 0.52f, 2.78f, 1.38f, 3.82f)
                lineToRelative(1.44f, -1.44f)
                curveTo(8.3f, 14.67f, 8f, 13.88f, 8f, 13f)
                curveToRelative(0f, -2.21f, 1.79f, -4f, 4f, -4f)
                reflectiveCurveToRelative(4f, 1.79f, 4f, 4f)
                curveToRelative(0f, 0.88f, -0.3f, 1.67f, -0.82f, 2.38f)
                lineToRelative(1.44f, 1.44f)
                curveTo(17.48f, 15.78f, 18f, 14.45f, 18f, 13f)
                curveToRelative(0f, -3.31f, -2.69f, -6f, -6f, -6f)
                close()
            }
        }.build()
    }

    val MeetingRoom: ImageVector by lazy {
        ImageVector.Builder(
            name = "MeetingRoom",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(19f, 19f)
                verticalLineTo(4f)
                horizontalLineToRelative(-4f)
                verticalLineTo(3f)
                horizontalLineTo(5f)
                verticalLineToRelative(16f)
                horizontalLineTo(3f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(12f)
                verticalLineTo(6f)
                horizontalLineToRelative(2f)
                verticalLineToRelative(15f)
                horizontalLineToRelative(4f)
                verticalLineToRelative(-2f)
                horizontalLineToRelative(-2f)
                close()
                moveTo(10f, 13f)
                curveToRelative(-0.55f, 0f, -1f, -0.45f, -1f, -1f)
                reflectiveCurveToRelative(0.45f, -1f, 1f, -1f)
                reflectiveCurveToRelative(1f, 0.45f, 1f, 1f)
                reflectiveCurveToRelative(-0.45f, 1f, -1f, 1f)
                close()
            }
        }.build()
    }

    val Star: ImageVector by lazy {
        ImageVector.Builder(
            name = "Star",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 17.27f)
                lineTo(18.18f, 21f)
                lineToRelative(-1.64f, -7.03f)
                lineTo(22f, 9.24f)
                lineToRelative(-7.19f, -0.61f)
                lineTo(12f, 2f)
                lineTo(9.19f, 8.63f)
                lineTo(2f, 9.24f)
                lineToRelative(5.46f, 4.73f)
                lineTo(5.82f, 21f)
                close()
            }
        }.build()
    }

    val Schedule: ImageVector by lazy {
        ImageVector.Builder(
            name = "Schedule",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(11.99f, 2f)
                curveTo(6.47f, 2f, 2f, 6.48f, 2f, 12f)
                reflectiveCurveToRelative(4.47f, 10f, 9.99f, 10f)
                curveTo(17.52f, 22f, 22f, 17.52f, 22f, 12f)
                reflectiveCurveTo(17.52f, 2f, 11.99f, 2f)
                close()
                moveTo(12f, 20f)
                curveToRelative(-4.42f, 0f, -8f, -3.58f, -8f, -8f)
                reflectiveCurveToRelative(3.58f, -8f, 8f, -8f)
                reflectiveCurveToRelative(8f, 3.58f, 8f, 8f)
                reflectiveCurveToRelative(-3.58f, 8f, -8f, 8f)
                close()
                moveTo(12.5f, 7f)
                horizontalLineTo(11f)
                verticalLineToRelative(6f)
                lineToRelative(5.25f, 3.15f)
                lineToRelative(0.75f, -1.23f)
                lineToRelative(-4.5f, -2.67f)
                close()
            }
        }.build()
    }

    val Bolt: ImageVector by lazy {
        ImageVector.Builder(
            name = "Bolt",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(11f, 21f)
                horizontalLineToRelative(-1f)
                lineToRelative(1f, -7f)
                horizontalLineTo(7.5f)
                curveToRelative(-0.58f, 0f, -0.57f, -0.32f, -0.38f, -0.66f)
                curveToRelative(0.19f, -0.34f, 0.05f, -0.08f, 0.07f, -0.12f)
                curveTo(8.48f, 10.94f, 10.42f, 7.54f, 13f, 3f)
                horizontalLineToRelative(1f)
                lineToRelative(-1f, 7f)
                horizontalLineToRelative(3.5f)
                curveToRelative(0.49f, 0f, 0.56f, 0.33f, 0.47f, 0.51f)
                lineToRelative(-0.07f, 0.15f)
                curveTo(12.96f, 17.55f, 11f, 21f, 11f, 21f)
                close()
            }
        }.build()
    }

    val ArrowForward: ImageVector by lazy {
        ImageVector.Builder(
            name = "ArrowForward",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(12f, 4f)
                lineToRelative(-1.41f, 1.41f)
                lineTo(16.17f, 11f)
                horizontalLineTo(4f)
                verticalLineToRelative(2f)
                horizontalLineToRelative(12.17f)
                lineToRelative(-5.58f, 5.59f)
                lineTo(12f, 20f)
                lineToRelative(8f, -8f)
                close()
            }
        }.build()
    }

    val ArrowBack: ImageVector by lazy {
        ImageVector.Builder(
            name = "ArrowBack",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(20f, 11f)
                horizontalLineTo(7.83f)
                lineToRelative(5.59f, -5.59f)
                lineTo(12f, 4f)
                lineToRelative(-8f, 8f)
                lineToRelative(8f, 8f)
                lineToRelative(1.41f, -1.41f)
                lineTo(7.83f, 13f)
                horizontalLineTo(20f)
                verticalLineToRelative(-2f)
                close()
            }
        }.build()
    }

    val Check: ImageVector by lazy {
        ImageVector.Builder(
            name = "Check",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(9f, 16.17f)
                lineTo(4.83f, 12f)
                lineToRelative(-1.42f, 1.41f)
                lineTo(9f, 19f)
                lineTo(21f, 7f)
                lineToRelative(-1.41f, -1.41f)
                close()
            }
        }.build()
    }

    val TouchApp: ImageVector by lazy {
        ImageVector.Builder(
            name = "TouchApp",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color.White)) {
                moveTo(9f, 11.24f)
                verticalLineTo(7.5f)
                curveTo(9f, 6.12f, 10.12f, 5f, 11.5f, 5f)
                reflectiveCurveTo(14f, 6.12f, 14f, 7.5f)
                verticalLineToRelative(3.74f)
                curveToRelative(1.21f, -0.81f, 2f, -2.18f, 2f, -3.74f)
                curveToRelative(0f, -2.49f, -2.01f, -4.5f, -4.5f, -4.5f)
                reflectiveCurveTo(7f, 5.01f, 7f, 7.5f)
                curveToRelative(0f, 1.56f, 0.79f, 2.93f, 2f, 3.74f)
                close()
                moveTo(18.84f, 15.25f)
                lineToRelative(-4.42f, -2.21f)
                curveToRelative(-0.25f, -0.13f, -0.53f, -0.19f, -0.82f, -0.19f)
                horizontalLineToRelative(-0.6f)
                verticalLineTo(7.5f)
                curveTo(13f, 6.67f, 12.33f, 6f, 11.5f, 6f)
                reflectiveCurveTo(10f, 6.67f, 10f, 7.5f)
                verticalLineToRelative(10.74f)
                lineToRelative(-3.61f, -0.75f)
                curveToRelative(-0.1f, -0.02f, -0.21f, -0.03f, -0.32f, -0.03f)
                curveToRelative(-0.41f, 0f, -0.78f, 0.17f, -1.05f, 0.44f)
                lineTo(4f, 18.9f)
                lineToRelative(5.59f, 5.59f)
                curveToRelative(0.43f, 0.43f, 1.02f, 0.69f, 1.66f, 0.69f)
                horizontalLineToRelative(7.5f)
                curveToRelative(1.1f, 0f, 2f, -0.9f, 2f, -2f)
                verticalLineToRelative(-6.25f)
                curveToRelative(0f, -0.73f, -0.4f, -1.39f, -1.04f, -1.68f)
                close()
            }
        }.build()
    }
}
