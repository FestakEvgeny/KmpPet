package evgeny.fetskovich.kmpstudy.app.ui.screens.signup

import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEvent
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInNavigationEvent
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi.SignUpStateHosting
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi.SignUpUserEvent
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider
import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.RegisterUserIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.RegisterUserUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val stateHosting: SignUpStateHosting,
    private val registerUserUseCase: RegisterUserUseCase,
    coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(
    coroutineDispatcher = coroutineDispatcher,
), UserEventProcessor {

    val screenState = stateHosting.screenState

    override fun processEvent(userEvent: UserEvent) {
        when (val parsedEvent = userEvent as? SignUpUserEvent) {
            SignUpUserEvent.CreateAccount -> createUserAccount()
            SignUpUserEvent.Login -> navigateBack()
            is SignUpUserEvent.UpdateConfirmPassword -> updateConfirmPassword(parsedEvent.text)
            is SignUpUserEvent.UpdatePassword -> updatePassword(parsedEvent.text)
            is SignUpUserEvent.UpdateUsername -> updateUserName(parsedEvent.text)
            null -> TODO()
        }
    }

    private fun updateUserName(value: String) {
        stateHosting.updateUsername(
            ValidationField(text = value)
        )
    }

    private fun updatePassword(value: String) {
        stateHosting.updatePassword(
            ValidationField(text = value)
        )
    }

    private fun updateConfirmPassword(value: String) {
        stateHosting.updateConfirmPassword(
            ValidationField(text = value)
        )
    }

    private fun createUserAccount() {
        val name = screenState.value.username.text
        val password = screenState.value.password.text

        if (!validateUserData()) {
            return
        }

        viewModelScope.launch {
            registerUserUseCase.execute(
                RegisterUserIntent(
                    name = name,
                    password = password
                )
            ).collectLatest {

            }
        }
    }

    private fun validateUserData(): Boolean {
        val name = screenState.value.username.text
        val password = screenState.value.password.text
        val passwordConfirmation = screenState.value.confirmPassword.text

        val isNameValid = name.isNotEmpty() // TODO Apply validation rules
        val isPasswordValid = password.isNotEmpty() // TODO Apply validation rules
        val isConfirmPasswordSame = passwordConfirmation == password

        if (isNameValid && isPasswordValid && isConfirmPasswordSame) {
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
                ),
                confirmPassword = ValidationField(
                    text = passwordConfirmation,
                    errorMessage = "",
                )
            )

            return false
        }
    }

    private fun navigateBack() {
        sendNavigation(SignInNavigationEvent.NavigateBack)
    }
}