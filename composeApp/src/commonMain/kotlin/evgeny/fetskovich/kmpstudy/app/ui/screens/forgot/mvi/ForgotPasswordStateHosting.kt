package evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.StateHosting
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import kotlinx.coroutines.flow.update

class ForgotPasswordStateHosting : StateHosting<ForgotPasswordScreenState>() {

    fun updateEmailText(
        text: ValidationField
    ) {
        _screenState.update {
            it.copy(
                userEmail = text,
            )
        }
    }

    override fun createInitialState(): ForgotPasswordScreenState = ForgotPasswordScreenState()
}