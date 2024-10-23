package evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent

sealed interface SignUpUserEvent : UserEvent {

    data class UpdateUsername(
        val text: String
    ) : SignUpUserEvent

    data class UpdatePassword(
        val text: String
    ) : SignUpUserEvent

    data class UpdateConfirmPassword(
        val text: String
    ) : SignUpUserEvent

    data object CreateAccount: SignUpUserEvent

    data object Login: SignUpUserEvent
}