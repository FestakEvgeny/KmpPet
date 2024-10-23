package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import cafe.adriel.voyager.navigator.LocalNavigator
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.MockUserEventProcessor
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.OnboardingFooter
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.OnboardingHeader
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager.OnboardingPager
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingPage
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingScreenNavigation
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingScreenState
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInNavigation
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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

private val horizontalPadding = 12.dp

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel
) {
    val navigator = LocalNavigator.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val state by viewModel.state.collectAsState()

    Screen(
        state = state,
        userEventProcessor = viewModel,
    )

    LaunchedEffect(Unit) {
        launch {
            viewModel.navigationResult
                .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
                .map { it as OnboardingScreenNavigation }
                .collectLatest { navigation ->
                    when (navigation) {
                        OnboardingScreenNavigation.CloseOnboarding -> {
                            navigator?.push(SignInNavigation())
                        }
                    }
                }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Screen(
    state: OnboardingScreenState,
    userEventProcessor: UserEventProcessor,
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
                currentPage = state.currentPage + 1,
                totalPages = state.onboardingPages.size,
                userEventProcessor,
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(
                        horizontal = horizontalPadding,
                        vertical = 8.dp,
                    )
            )
        },
        bottomBar = {
            OnboardingFooter(
                prevButtonText = state.prevButtonText,
                nextButtonText = state.nextButtonText,
                pagerState = pagerState,
                userEventProcessor,
                modifier = Modifier
                    .navigationBarsPadding()
                    .padding(
                        horizontal = horizontalPadding,
                        vertical = 8.dp,
                    )
            )
        }
    ) { paddings ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(paddings)
                .consumeWindowInsets(paddings)
                .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))
                .fillMaxSize(),
        ) {
            OnboardingPager(
                pages = state.onboardingPages,
                pagerState = pagerState,
                modifier = Modifier
                    .padding(
                        horizontal = horizontalPadding,
                    )
            )
        }
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }
            .collectLatest { page ->
                userEventProcessor.processEvent(OnboardingUserEvent.UpdatePage(page))
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

        Screen(
            state = state,
            userEventProcessor = MockUserEventProcessor,
        )
    }
}