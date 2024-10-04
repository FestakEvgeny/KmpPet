package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInUserEvent
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.AuthorizeUserIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.AuthorizeUserUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignInViewModel(
    private val stateHosting: SignInStateHosting,
    private val authorizeUserUseCase: AuthorizeUserUseCase,
    private val coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(), UserEventProcessor {

    val screenState = stateHosting.screenState

    override fun processEvent(userEvent: UserEvent) {
        when (val parsedEvent = userEvent as? SignInUserEvent) {
            SignInUserEvent.ForgotPassword -> forgotPassword()
            SignInUserEvent.Login -> login()
            SignInUserEvent.SignUp -> signUp()
            is SignInUserEvent.UpdatePassword -> updatePassword(parsedEvent.text)
            is SignInUserEvent.UpdateUsername -> updateUserName(parsedEvent.text)
            null -> {
                // do nothing
            }
        }
    }

    private fun forgotPassword() {

    }

    private fun login() {
        if (!validateAuthorizationData()) {
            return
        }

        viewModelScope.launch(coroutineDispatcher.io) {
            authorizeUserUseCase.execute(
                AuthorizeUserIntent(
                    name = screenState.value.username.text,
                    password = screenState.value.password.text
                )
            ).collectLatest {

            }
        }
    }

    private fun validateAuthorizationData(): Boolean {
        val name = screenState.value.username.text
        val password = screenState.value.password.text

        val isNameValid = name.isNotEmpty()
        val isPasswordValid = password.isNotEmpty()

        if (isNameValid && isPasswordValid) {
            return true
        } else {
            stateHosting.updateAuthorizationData(
                name = ValidationField(
                    text = name,
                    errorMessage = "Not valid"
                ),
                password = ValidationField(
                    text = password,
                    errorMessage = "Not Valid",
                )
            )

            return false
        }
    }

    private fun signUp() {

    }

    private fun updatePassword(value: String) {
        stateHosting.updatePassword(
            ValidationField(text = value)
        )
    }

    private fun updateUserName(value: String) {
        stateHosting.updateUsername(
            ValidationField(text = value)
        )
    }
}