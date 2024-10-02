package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.OnboardingFooter
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.OnboardingHeader
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager.OnboardingPager
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingPage
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingScreenState
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_first_page
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_second_page
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_third_page
import fetskovichkmppet.composeapp.generated.resources.onboarding_next
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_title
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_second_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_second_title
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_third_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_third_title
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel
) {
    val state by viewModel.state.collectAsState()

    Screen(
        state = state,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Screen(
    state: OnboardingScreenState
) {
    val pagerState = rememberPagerState(
        initialPage = state.currentPage,
        pageCount = {
            state.onboardingPages.size
        }
    )

    Scaffold(
        topBar = {
            OnboardingHeader(
                pageIndicator = state.pageIndication,
            )
        },
        bottomBar = {
            OnboardingFooter(
                prevButtonText = state.prevButtonText,
                nextButtonText = state.nextButtonText,
                pagerState = pagerState,
            )
        }
    ) { paddings ->

        Column(
            modifier = Modifier
                .padding(paddings)
        ) {
            OnboardingPager(
                pages = state.onboardingPages,
                pagerState = pagerState,
            )
        }
    }
}

@Preview
@Composable
private fun ScreenPreview() {
    AppTheme {
        val state = OnboardingScreenState(
            currentPage = 0,
            prevButtonText = null,
            nextButtonText = Res.string.onboarding_next,
            onboardingPages = persistentListOf(
                OnboardingPage(
                    image = Res.drawable.ic_onboarding_first_page,
                    title = Res.string.onboarding_page_first_title,
                    message = Res.string.onboarding_page_first_text,
                ),
                OnboardingPage(
                    image = Res.drawable.ic_onboarding_second_page,
                    title = Res.string.onboarding_page_second_title,
                    message = Res.string.onboarding_page_second_text,
                ),
                OnboardingPage(
                    image = Res.drawable.ic_onboarding_third_page,
                    title = Res.string.onboarding_page_third_title,
                    message = Res.string.onboarding_page_third_text,
                ),
            ),
        )

        Screen(state)
    }
}