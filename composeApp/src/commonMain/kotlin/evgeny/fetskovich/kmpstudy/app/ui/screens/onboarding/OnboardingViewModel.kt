package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingScreenNavigation
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingUserEvent
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider

class OnboardingViewModel(
    private val stateHosting: OnboardingStateHosting,
    coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(coroutineDispatcher), UserEventProcessor {

    val state = stateHosting.screenState

    override fun processEvent(userEvent: UserEvent) {
        (userEvent as? OnboardingUserEvent)?.let { event ->
            when (event) {
                is OnboardingUserEvent.UpdatePage -> updatePage(event.page)
                OnboardingUserEvent.CloseOnboarding -> closeOnboarding()
            }
        }
    }

    private fun updatePage(page: Int) {
        stateHosting.updateScreenPage(page)
    }

    private fun closeOnboarding() {
        sendNavigation(OnboardingScreenNavigation.CloseOnboarding)
    }
}