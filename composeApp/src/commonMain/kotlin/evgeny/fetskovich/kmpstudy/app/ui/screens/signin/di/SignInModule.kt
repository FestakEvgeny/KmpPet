package evgeny.fetskovich.kmpstudy.app.ui.screens.signin.di

import evgeny.fetskovich.kmpstudy.app.extensions.viewModelDefinition
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInViewModel
import org.koin.dsl.module

val signInModule = module {
    viewModelDefinition {
        SignInViewModel()
    }
}