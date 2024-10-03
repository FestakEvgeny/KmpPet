@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)

package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.MockUserEventProcessor
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.modifiers.cleanClickable
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager.OnboardingPagerIndicator
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.onboarding_next
import fetskovichkmppet.composeapp.generated.resources.onboarding_prev
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingFooter(
    prevButtonText: StringResource?,
    nextButtonText: StringResource,
    pagerState: PagerState,
    userEventProcessor: UserEventProcessor,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    Box  {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
        ) {

            if (prevButtonText == null) {
                Spacer(Modifier.width(1.dp))
            }

            AnimatedVisibility(prevButtonText != null) {
                if (prevButtonText != null) {
                    Text(
                        text = stringResource(prevButtonText),
                        color = AppColors.brightGray,
                        style = KmpTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .cleanClickable {
                                scope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                    )
                }
            }

            Text(
                text = stringResource(nextButtonText),
                color = AppColors.primary,
                style = KmpTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .cleanClickable {
                        if (pagerState.currentPage != pagerState.pageCount - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            userEventProcessor.processEvent(OnboardingUserEvent.CloseOnboarding)
                        }
                    }
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            OnboardingPagerIndicator(
                pagerState = pagerState,
            )
        }
    }
}

@Preview
@Composable
private fun OnboardingFooterPreview() {
    AppTheme {
        val pagerState = rememberPagerState { 2 }

        OnboardingFooter(
            prevButtonText = Res.string.onboarding_prev,
            nextButtonText = Res.string.onboarding_next,
            pagerState = pagerState,
            userEventProcessor = MockUserEventProcessor,
        )
    }
}

@Preview
@Composable
private fun OnboardingFooterWithoutPrevPreview() {
    AppTheme {
        val pagerState = rememberPagerState { 2 }

        OnboardingFooter(
            prevButtonText = null,
            nextButtonText = Res.string.onboarding_next,
            pagerState = pagerState,
            userEventProcessor = MockUserEventProcessor,
        )
    }
}
