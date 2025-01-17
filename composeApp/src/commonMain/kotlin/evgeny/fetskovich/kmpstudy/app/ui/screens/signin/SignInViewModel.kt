package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInNavigationEvent
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInUserEvent
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider
import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.AuthorizeUserIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.AuthorizeUserUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignInViewModel(
    private val stateHosting: SignInStateHosting,
    private val authorizeUserUseCase: AuthorizeUserUseCase,
    coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(coroutineDispatcher), UserEventProcessor {

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

        val isNameValid = name.isNotEmpty() // TODO Apply validation rules
        val isPasswordValid = password.isNotEmpty() // TODO Apply validation rules

        if (isNameValid && isPasswordValid) {
            return true
        } else {
            stateHosting.updateAuthorizationData(
                name = ValidationField(
                    text = name,
                    errorMessage = "Not valid" // TODO Fix res
                ),
                password = ValidationField(
                    text = password,
                    errorMessage = "Not Valid", // TODO Fix res
                )
            )

            return false
        }
    }

    private fun signUp() {
        sendNavigation(SignInNavigationEvent.ToSignUp)
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