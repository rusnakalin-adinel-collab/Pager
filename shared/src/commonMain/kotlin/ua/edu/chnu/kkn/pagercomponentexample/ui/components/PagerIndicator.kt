package ua.edu.chnu.kkn.pagercomponentexample.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ua.edu.chnu.kkn.pagercomponentexample.theme.FitPulseColors

@Composable
fun PagerIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val isSelected = index == currentPage
            val targetWidth by animateDpAsState(
                targetValue = if (isSelected) 28.dp else 6.dp,
                animationSpec = tween(durationMillis = 300)
            )
            val targetColor by animateColorAsState(
                targetValue = if (isSelected) FitPulseColors.PrimaryContainer else FitPulseColors.SurfaceContainerHighest,
                animationSpec = tween(durationMillis = 300)
            )

            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(targetWidth)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(targetColor)
            )
        }
    }
}
