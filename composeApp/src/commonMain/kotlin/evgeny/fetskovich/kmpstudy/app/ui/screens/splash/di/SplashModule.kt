package evgeny.fetskovich.kmpstudy.app.ui.screens.splash.di

import evgeny.fetskovich.kmpstudy.app.extensions.viewModelDefinition
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.SplashViewModel
import org.koin.dsl.module

val splashModule = module {

    viewModelDefinition {
        SplashViewModel(
            setupInitialDataUseCase = get(),
        )
    }
}