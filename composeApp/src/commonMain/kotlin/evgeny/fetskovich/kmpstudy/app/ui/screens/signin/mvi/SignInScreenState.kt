package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.ScreenState
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField

data class SignInScreenState(
    val username: ValidationField,
    val password: ValidationField,
) : ScreenState
