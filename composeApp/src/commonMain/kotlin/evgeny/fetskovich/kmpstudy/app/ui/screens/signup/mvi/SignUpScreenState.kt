package evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.ScreenState
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField

data class SignUpScreenState (
    val username: ValidationField,
    val password: ValidationField,
    val confirmPassword: ValidationField
): ScreenState