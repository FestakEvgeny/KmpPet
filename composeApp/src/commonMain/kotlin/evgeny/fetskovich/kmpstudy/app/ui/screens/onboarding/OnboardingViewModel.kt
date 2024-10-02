package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingUserEvent

class OnboardingViewModel(
    private val stateHosting: OnboardingStateHosting,
) : BaseViewModel(), UserEventProcessor {

    val state = stateHosting.screenState

    override fun processEvent(userEvent: UserEvent) {
        (userEvent as? OnboardingUserEvent)?.let { event ->
            when (event) {
                is OnboardingUserEvent.UpdatePage -> updatePage(event.page)
            }
        }
    }

    private fun updatePage(page: Int) {
        stateHosting.updateScreenPage(page)
    }
}