package evgeny.fetskovich.kmpstudy.app.di.domain

import evgeny.fetskovich.kmpstudy.domain.usecase.initial.AuthorizeUserUseCase
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SetupInitialDataUseCase() }
    factory {
        AuthorizeUserUseCase(
            userRepository = get(),
        )
    }
}