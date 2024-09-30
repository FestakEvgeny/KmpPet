package evgeny.fetskovich.kmpstudy.app.di

import org.koin.dsl.module

val sharedIosModule  = module {
    includes(sharedModule)
}