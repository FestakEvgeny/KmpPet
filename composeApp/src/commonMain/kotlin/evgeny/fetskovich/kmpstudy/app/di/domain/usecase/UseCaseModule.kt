package evgeny.fetskovich.kmpstudy.app.di.domain.usecase

import evgeny.fetskovich.kmpstudy.app.di.domain.usecase.authorization.authorizationUseCaseModule
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { SetupInitialDataUseCase() }

    includes(authorizationUseCaseModule)
}