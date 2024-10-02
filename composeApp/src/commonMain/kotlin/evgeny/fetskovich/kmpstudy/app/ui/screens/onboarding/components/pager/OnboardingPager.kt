@file:OptIn(ExperimentalFoundationApi::class)

package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingPage
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.compose_multiplatform
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_title
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.ui.tooling.preview.Preview

private val horizontalPadding = 22.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPager(
    pages: PersistentList<OnboardingPage>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
) {

    val maxHeight = remember { mutableStateOf(Dp.Unspecified) }

    HorizontalPager(
        state = pagerState,
        pageSpacing = horizontalPadding,
        contentPadding = PaddingValues(
            horizontal = horizontalPadding,
        ),
        beyondBoundsPageCount = pagerState.pageCount,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) { page ->

        OnboardingPagerContent(
            page = pages[page],
            modifier = Modifier
                .sameLimitedHeight(maxHeight)
        )
    }
}

private fun Modifier.sameLimitedHeight(
    maxHeight: MutableState<Dp>
): Modifier = composed {
    val density = LocalDensity.current

    this
        .heightIn(
            min = maxHeight.value,
            max = maxHeight.value,
        )
        .onSizeChanged {
            density.run {
                val updateHeight = it.height.toDp()
                if (updateHeight > maxHeight.value || maxHeight.value == Dp.Unspecified) {
                    maxHeight.value = updateHeight
                }
            }
        }
}

@Preview
@Composable
private fun OnboardingPagerPreview() {
    AppTheme {
        val pagerState = rememberPagerState { 3 }

        OnboardingPager(
            pages = persistentListOf(
                OnboardingPage(
                    image = Res.drawable.compose_multiplatform,
                    title = Res.string.onboarding_page_first_title,
                    message = Res.string.onboarding_page_first_text,
                ),
                OnboardingPage(
                    image = Res.drawable.compose_multiplatform,
                    title = Res.string.onboarding_page_first_title,
                    message = Res.string.onboarding_page_first_text,
                ),
                OnboardingPage(
                    image = Res.drawable.compose_multiplatform,
                    title = Res.string.onboarding_page_first_title,
                    message = Res.string.onboarding_page_first_text,
                )
            ),
            pagerState = pagerState,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}