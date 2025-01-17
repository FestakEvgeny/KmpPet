package evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation

sealed interface SignUpNavigationEvent : Navigation {

    data object NavigateBack: Navigation
}