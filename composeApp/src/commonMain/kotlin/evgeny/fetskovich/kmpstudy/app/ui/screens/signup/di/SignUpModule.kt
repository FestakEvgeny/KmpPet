package evgeny.fetskovich.kmpstudy.app.ui.screens.signup.di

import evgeny.fetskovich.kmpstudy.app.extensions.viewModelDefinition
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.SignUpViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi.SignUpStateHosting
import org.koin.dsl.module

val signUpModule = module {

    factory { SignUpStateHosting() }

    viewModelDefinition {
        SignUpViewModel(
            stateHosting = get(),
            registerUserUseCase = get(),
            coroutineDispatcher = get(),
        )
    }
}