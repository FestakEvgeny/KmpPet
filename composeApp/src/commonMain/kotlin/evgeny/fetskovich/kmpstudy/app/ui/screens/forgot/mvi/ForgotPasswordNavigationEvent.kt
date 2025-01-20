package evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation

sealed interface ForgotPasswordNavigationEvent : Navigation {

    data object ToLogin : ForgotPasswordNavigationEvent
}