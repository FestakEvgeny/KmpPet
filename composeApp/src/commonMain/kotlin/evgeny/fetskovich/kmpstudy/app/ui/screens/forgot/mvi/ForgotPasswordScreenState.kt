package evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.ScreenState
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField

data class ForgotPasswordScreenState (
    val userEmail: ValidationField = ValidationField()
): ScreenState