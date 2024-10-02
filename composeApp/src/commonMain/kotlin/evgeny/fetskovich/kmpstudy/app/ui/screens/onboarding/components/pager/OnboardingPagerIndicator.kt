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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
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
            modifier = modifier
                .height(48.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(pagerState.pageCount) { index ->
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                )
            }
        }

        Box(
            Modifier
                .wormTransition(pagerState)
                .size(20.dp)
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
    drawPath(path = path, color = Color.White)
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
