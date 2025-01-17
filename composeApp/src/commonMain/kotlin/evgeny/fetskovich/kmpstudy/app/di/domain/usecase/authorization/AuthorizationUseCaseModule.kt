package evgeny.fetskovich.kmpstudy.app.di.domain.usecase.authorization

import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.AuthorizeUserUseCase
import evgeny.fetskovich.kmpstudy.domain.usecase.authorization.RegisterUserUseCase
import org.koin.dsl.module

val authorizationUseCaseModule = module {
    factory {
        AuthorizeUserUseCase(
            userRepository = get(),
        )
    }

    factory {
        RegisterUserUseCase(
            userRepository = get(),
        )
    }
}