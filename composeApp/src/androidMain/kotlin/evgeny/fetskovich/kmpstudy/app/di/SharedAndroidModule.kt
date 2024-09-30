package evgeny.fetskovich.kmpstudy.app.di

import android.app.Application
import android.content.Context
import org.koin.dsl.module
import java.util.Locale

fun sharedAndroidModule(application: Application) = module {
    single<Context> { application }
    single<Locale> { Locale.getDefault() }

    includes(sharedModule)
}