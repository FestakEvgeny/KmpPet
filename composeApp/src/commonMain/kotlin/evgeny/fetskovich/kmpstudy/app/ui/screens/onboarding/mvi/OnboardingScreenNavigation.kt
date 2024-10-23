package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation

sealed interface OnboardingScreenNavigation : Navigation {

    data object CloseOnboarding: OnboardingScreenNavigation
}