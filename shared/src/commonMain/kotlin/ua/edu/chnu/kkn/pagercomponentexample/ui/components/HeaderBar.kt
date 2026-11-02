package ua.edu.chnu.kkn.pagercomponentexample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors

@Composable
fun HeaderBar(
    isUkrainian: Boolean,
    onLanguageToggle: (Boolean) -> Unit,
    onSkip: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Language Toggle UA / EN
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
                    .clickable { onLanguageToggle(true) }
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "UA",
                    color = if (isUkrainian) FitPulseColors.Primary else FitPulseColors.TextSecondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(if (!isUkrainian) FitPulseColors.SurfaceContainerHigh else Color.Transparent)
                    .clickable { onLanguageToggle(false) }
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "EN",
                    color = if (!isUkrainian) FitPulseColors.Primary else FitPulseColors.TextSecondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                )
            }
        }

        // Skip button
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable { onSkip() }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isUkrainian) "ПРОПУСТИТИ" else "SKIP",
                color = FitPulseColors.OnSurfaceVariant,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 1.sp
            )
        }
    }
}
