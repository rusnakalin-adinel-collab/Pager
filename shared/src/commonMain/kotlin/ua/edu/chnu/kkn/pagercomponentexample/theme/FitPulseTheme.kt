package ua.edu.chnu.kkn.pagercomponentexample.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object FitPulseColors {
    val Background = Color(0xFF10131A)
    val Surface = Color(0xFF10131A)
    val SurfaceCanvas = Color(0xFF0D0F12)
    val SurfaceCard = Color(0xFF161920)
    val SurfaceContainerLowest = Color(0xFF0B0E15)
    val SurfaceContainerLow = Color(0xFF191C23)
    val SurfaceContainer = Color(0xFF1D2027)
    val SurfaceContainerHigh = Color(0xFF272A31)
    val SurfaceContainerHighest = Color(0xFF32353C)
    val SurfaceBright = Color(0xFF363941)

    val Primary = Color(0xFFFFFFFF)
    val OnPrimary = Color(0xFF283500)
    val PrimaryContainer = Color(0xFFC3F400) // Electric Lime
    val PrimaryFixedDim = Color(0xFFABD600)
    val OnPrimaryFixed = Color(0xFF161E00)
    val OnPrimaryContainer = Color(0xFF556D00)

    val Secondary = Color(0xFFD3FBFF)
    val SecondaryContainer = Color(0xFF00EEFC) // Pulse Cyan
    val SecondaryFixed = Color(0xFF7DF4FF)
    val SecondaryFixedDim = Color(0xFF00DBE9)
    val OnSecondary = Color(0xFF00363A)
    val OnSecondaryFixed = Color(0xFF002022)

    val Tertiary = Color(0xFFFFFFFF)
    val TertiaryContainer = Color(0xFFFFD9DC)
    val Error = Color(0xFFFF5376) // Hyper Coral
    val ErrorContainer = Color(0xFF93000A)
    val OnErrorContainer = Color(0xFFFFDAD6)

    val TextPrimary = Color(0xFFF3F4F6)
    val TextSecondary = Color(0xFF9CA3AF)
    val TextTertiary = Color(0xFF6B7280)
    val OnSurface = Color(0xFFE0E2EC)
    val OnSurfaceVariant = Color(0xFFC4C9AC)
    val Outline = Color(0xFF8E9379)
    val OutlineVariant = Color(0xFF444933)
}

private val DarkColorScheme = darkColorScheme(
    primary = FitPulseColors.Primary,
    onPrimary = FitPulseColors.OnPrimary,
    primaryContainer = FitPulseColors.PrimaryContainer,
    onPrimaryContainer = FitPulseColors.OnPrimaryContainer,
    secondary = FitPulseColors.Secondary,
    onSecondary = FitPulseColors.OnSecondary,
    secondaryContainer = FitPulseColors.SecondaryContainer,
    background = FitPulseColors.Background,
    onBackground = FitPulseColors.OnSurface,
    surface = FitPulseColors.Surface,
    onSurface = FitPulseColors.OnSurface,
    surfaceVariant = FitPulseColors.SurfaceContainerHighest,
    onSurfaceVariant = FitPulseColors.OnSurfaceVariant,
    error = FitPulseColors.Error,
    errorContainer = FitPulseColors.ErrorContainer
)

@Composable
fun FitPulseTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
