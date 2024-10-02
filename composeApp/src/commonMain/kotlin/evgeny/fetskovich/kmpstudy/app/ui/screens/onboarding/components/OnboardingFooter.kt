@file:OptIn(ExperimentalFoundationApi::class)

package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager.OnboardingPagerIndicator
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.onboarding_next
import fetskovichkmppet.composeapp.generated.resources.onboarding_prev
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingFooter(
    prevButtonText: StringResource?,
    nextButtonText: StringResource,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {

        if (prevButtonText != null) {
            Text(
                text = stringResource(prevButtonText),
                color = AppColors.brightGray,
                style = KmpTheme.typography.bodyLarge,
            )
        }

        OnboardingPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = stringResource(nextButtonText),
            color = AppColors.primary,
            style = KmpTheme.typography.bodyLarge,
        )
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
        )
    }
}
