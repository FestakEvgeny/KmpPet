package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent

sealed interface OnboardingUserEvent : UserEvent {

    data object CloseOnboarding: OnboardingUserEvent

    class UpdatePage(
        val page: Int
    ) : OnboardingUserEvent
}