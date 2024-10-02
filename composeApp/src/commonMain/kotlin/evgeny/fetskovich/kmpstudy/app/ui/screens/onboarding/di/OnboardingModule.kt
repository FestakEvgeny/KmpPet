package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.di

import evgeny.fetskovich.kmpstudy.app.extensions.viewModelDefinition
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.OnboardingViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingStateHosting
import org.koin.dsl.module

val onboardingModule = module {

    factory { OnboardingStateHosting() }

    viewModelDefinition {
        OnboardingViewModel(
            stateHosting = get(),
        )
    }
}