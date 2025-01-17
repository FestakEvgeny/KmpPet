package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation

sealed interface SignInNavigationEvent :  Navigation {

    data object NavigateBack: SignInNavigationEvent

    data object ToSignUp: SignInNavigationEvent
}