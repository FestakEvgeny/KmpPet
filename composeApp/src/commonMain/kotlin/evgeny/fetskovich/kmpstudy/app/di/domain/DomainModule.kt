package evgeny.fetskovich.kmpstudy.app.di.domain

import org.koin.dsl.module

val domainModule = module {
    includes(useCaseModule)
}