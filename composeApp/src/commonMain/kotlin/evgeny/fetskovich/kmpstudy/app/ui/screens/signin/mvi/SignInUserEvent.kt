package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent

sealed interface SignInUserEvent : UserEvent {

    data class UpdateUsername(
        val text: String
    ) : SignInUserEvent

    data class UpdatePassword(
        val text: String
    ) : SignInUserEvent

    data object Login : SignInUserEvent

    data object SignUp : SignInUserEvent

    data object ForgotPassword : SignInUserEvent
}
