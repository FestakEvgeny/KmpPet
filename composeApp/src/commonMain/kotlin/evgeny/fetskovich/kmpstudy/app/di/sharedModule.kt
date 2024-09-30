package evgeny.fetskovich.kmpstudy.app.di

import evgeny.fetskovich.kmpstudy.app.base.isDebug
import evgeny.fetskovich.kmpstudy.app.di.data.dataModule
import evgeny.fetskovich.kmpstudy.app.di.domain.domainModule
import evgeny.fetskovich.kmpstudy.app.di.presentation.presentationModule
import org.koin.dsl.module

val sharedModule = module {
    includes(
        dataModule(
            isDebug = isDebug
        )
    )
    includes(domainModule)
    includes(presentationModule)
}