package evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.StateHosting
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import kotlinx.coroutines.flow.update

class SignUpStateHosting : StateHosting<SignUpScreenState>(){

    fun updateUsername(
        value: ValidationField
    ) {
        _screenState.update {
            it.copy(
                username = value,
            )
        }
    }

    fun updatePassword(
        value: ValidationField
    ) {
        _screenState.update {
            it.copy(
                password = value,
            )
        }
    }

    fun updateConfirmPassword(
        value: ValidationField
    ){
        _screenState.update {
            it.copy(
                confirmPassword = value,
            )
        }
    }

    fun updateAuthorizationData(
        name: ValidationField,
        password: ValidationField,
        confirmPassword: ValidationField,
    ) {
        _screenState.update {
            it.copy(
                username = name,
                password = password,
                confirmPassword = confirmPassword,
            )
        }
    }

    override fun createInitialState(): SignUpScreenState = SignUpScreenState(
        username = ValidationField(),
        password = ValidationField(),
        confirmPassword = ValidationField(),
    )
}