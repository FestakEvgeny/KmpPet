package evgeny.fetskovich.kmpstudy.app.di.domain.usecase.authorization

import evgeny.fetskovich.kmpstudy.domain.usecase.initial.AuthorizeUserUseCase
import org.koin.dsl.module

val authorizationUseCaseModule = module {
    factory {
        AuthorizeUserUseCase(
            userRepository = get(),
        )
    }
}