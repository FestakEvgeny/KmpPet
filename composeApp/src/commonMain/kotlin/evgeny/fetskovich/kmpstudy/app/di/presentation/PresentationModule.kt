package evgeny.fetskovich.kmpstudy.app.di.presentation

import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.di.onboardingModule
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.di.signInModule
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.di.splashModule
import org.koin.dsl.module

val presentationModule = module {
    includes(splashModule, onboardingModule, signInModule)
}