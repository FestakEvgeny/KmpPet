package evgeny.fetskovich.kmpstudy.app.di.domain

import evgeny.fetskovich.kmpstudy.app.di.domain.usecase.useCaseModule
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProviderImpl
import org.koin.dsl.module

val domainModule = module {
    single<CoroutineContextProvider> { CoroutineContextProviderImpl() }

    includes(useCaseModule)
}