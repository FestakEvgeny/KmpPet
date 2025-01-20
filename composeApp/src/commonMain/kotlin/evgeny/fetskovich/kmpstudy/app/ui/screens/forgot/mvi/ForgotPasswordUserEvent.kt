package evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent

sealed interface ForgotPasswordUserEvent : UserEvent {

    data class ChangeEmailInput(val text: String): ForgotPasswordUserEvent

    data object SubmitEmail: ForgotPasswordUserEvent
}