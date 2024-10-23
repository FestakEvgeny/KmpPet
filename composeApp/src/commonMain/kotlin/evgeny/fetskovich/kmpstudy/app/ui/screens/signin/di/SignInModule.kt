package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.di

import evgeny.fetskovich.kmpstudy.app.extensions.viewModelDefinition
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInStateHosting
import org.koin.dsl.module

val signInModule = module {
    factory { SignInStateHosting() }

    viewModelDefinition {
        SignInViewModel(
            stateHosting = get(),
            authorizeUserUseCase = get(),
            coroutineDispatcher = get(),
        )
    }
}