package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

private const val INDICATOR_WIDTH_DP = 10
private const val INDICATOR_HEIGHT_DP = 10
private const val INDICATOR_SPACING_DP = 10
private const val ACTIVE_INDICATOR_WIDTH_DP = 40
private const val INDICATOR_RADIUS = 50f

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
    val density = LocalDensity.current

    val dotWidth = with(density) {
        remember { INDICATOR_WIDTH_DP.dp.toPx() }
    }
    val dotHeight = with(density) {
        remember { INDICATOR_HEIGHT_DP.dp.toPx() }
    }
    val spacing = with(density) {
        remember { INDICATOR_SPACING_DP.dp.toPx() }
    }

    val activeDotWidth = with(density) {
        remember { ACTIVE_INDICATOR_WIDTH_DP.dp.toPx() }
    }

    val totalWidth = remember(pagerState.pageCount) {
        val notActiveIndicators = pagerState.pageCount - 1
        val indicatorsTotalWidth =
            ACTIVE_INDICATOR_WIDTH_DP + (INDICATOR_WIDTH_DP * notActiveIndicators)
        val indicatorsTotalSpace = notActiveIndicators * INDICATOR_SPACING_DP

        (indicatorsTotalWidth + indicatorsTotalSpace).dp
    }

    Canvas(
        modifier = modifier
            .width(totalWidth)
    ) {
        var x = 0f
        val y = center.y

        repeat(pagerState.pageCount) { i ->
            val posOffset = pagerState.currentPage + pagerState.currentPageOffsetFraction
            val dotOffset = posOffset % 1
            val current = posOffset.toInt()

            val factor = (dotOffset * (activeDotWidth - dotWidth))

            val calculatedWidth = when {
                i == current -> activeDotWidth - factor
                i - 1 == current -> dotWidth + factor
                i == 0 && posOffset > pagerState.pageCount - 1 -> dotWidth + factor
                else -> dotWidth
            }

            drawIndicator(
                x = x,
                y = y,
                width = calculatedWidth,
                height = dotHeight,
                radius = CornerRadius(INDICATOR_RADIUS)
            )

            x += calculatedWidth + spacing
        }
    }
}

private fun DrawScope.drawIndicator(
    x: Float,
    y: Float,
    width: Float,
    height: Float,
    radius: CornerRadius
) {
    val rect = RoundRect(
        left = x,
        top = y - height / 2,
        right = x + width,
        bottom = y + height / 2,
        cornerRadius = radius
    )
    val path = Path().apply { addRoundRect(rect) }
    drawPath(path = path, color = AppColors.primary)
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
