package evgeny.fetskovich.kmpstudy.app.ui.screens.forgot

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi.ForgotPasswordStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.forgot.mvi.ForgotPasswordUserEvent
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider

class ForgotPasswordViewModel (
    private val stateHosting: ForgotPasswordStateHosting,
    coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(coroutineDispatcher), UserEventProcessor {

    override fun processEvent(userEvent: UserEvent) {
       if (userEvent is ForgotPasswordUserEvent) {
           processScreenEvent(userEvent)
       }
    }

    private fun processScreenEvent(event: ForgotPasswordUserEvent) {
        when(event) {
            ForgotPasswordUserEvent.SubmitEmail -> submitEmail()
            is ForgotPasswordUserEvent.ChangeEmailInput -> changeEmailInput(event.text)
        }
    }

    private fun submitEmail() {



    }

    private fun changeEmailInput(text: String) {
        stateHosting.updateEmailText(
            ValidationField(text = text)
        )
    }
}