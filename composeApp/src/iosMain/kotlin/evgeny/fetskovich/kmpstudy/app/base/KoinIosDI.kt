package evgeny.fetskovich.kmpstudy.app.base

import evgeny.fetskovich.kmpstudy.app.di.sharedIosModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(sharedIosModule)
    }
}