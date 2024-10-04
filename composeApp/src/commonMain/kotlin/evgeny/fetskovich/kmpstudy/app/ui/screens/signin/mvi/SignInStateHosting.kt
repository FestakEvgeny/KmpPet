package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.StateHosting
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import kotlinx.coroutines.flow.update

class SignInStateHosting : StateHosting<SignInScreenState>() {

    fun updateUsername(
        name: ValidationField
    ) {
        _screenState.update {
            it.copy(
                username = name,
            )
        }
    }

    fun updatePassword(
        password: ValidationField
    ) {
        _screenState.update {
            it.copy(
                password = password,
            )
        }
    }

    fun updateAuthorizationData(
        name: ValidationField,
        password: ValidationField
    ) {
        _screenState.update {
            it.copy(
                username = name,
                password = password,
            )
        }
    }

    override fun createInitialState(): SignInScreenState = SignInScreenState(
        username = ValidationField(
            text = "",
        ),
        password = ValidationField(
            text = "",
        )
    )
}