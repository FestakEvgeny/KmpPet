package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInStateHosting

class SignInViewModel (
    private val stateHosting: SignInStateHosting
) : BaseViewModel() {

    val screenState = stateHosting.screenState
}