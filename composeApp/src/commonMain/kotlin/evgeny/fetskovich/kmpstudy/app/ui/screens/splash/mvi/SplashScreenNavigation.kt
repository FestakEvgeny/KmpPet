package evgeny.fetskovich.kmpstudy.app.ui.screens.splash.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation

sealed interface SplashScreenNavigation  : Navigation {

    data object OpenOnboarding : SplashScreenNavigation

    data object OpenMainScreen : SplashScreenNavigation

    data object OpenLoginScreen: SplashScreenNavigation
}
