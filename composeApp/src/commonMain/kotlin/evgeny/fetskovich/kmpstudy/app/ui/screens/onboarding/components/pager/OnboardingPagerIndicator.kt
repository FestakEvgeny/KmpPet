package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {
    PagerIndicator(
        pagerState = pagerState,
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier,
        ) {
            repeat(pagerState.pageCount) { index ->
                val color = if (index == pagerState.currentPage) {
                    AppColors.selectedIndicator
                } else {
                    AppColors.unselectedIndicator
                }

                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            color = color,
                            shape = CircleShape
                        )
                )
            }
        }

        Box(
            Modifier
                .size(10.dp)
                .wormTransition(pagerState)

        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun Modifier.wormTransition(
    pagerState: PagerState
) = drawBehind {
    val distance = size.width + 10.dp.roundToPx()
    val scrollPosition = pagerState.currentPage + pagerState.currentPageOffsetFraction
    val wormOffset = (scrollPosition % 1) * 2

    val xPos = scrollPosition.toInt() * distance
    val head = xPos + distance * 0f.coerceAtLeast(wormOffset - 1)
    val tail = xPos + size.width + 1f.coerceAtMost(wormOffset) * distance

    val worm = RoundRect(
        left = head,
        top = 0f,
        right = tail,
        bottom = size.height,
        cornerRadius = CornerRadius(50f)
    )

    val path = Path().apply { addRoundRect(worm) }
    drawPath(path = path, color = AppColors.unselectedIndicator)
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
private fun PagerIndicatorPreview() {
    AppTheme {
        Column(
            modifier = Modifier
                .height(100.dp)
        ) {
            val pagerState = rememberPagerState { 2 }

            OnboardingPagerIndicator(
                pagerState = pagerState
            )
        }
    }
}
