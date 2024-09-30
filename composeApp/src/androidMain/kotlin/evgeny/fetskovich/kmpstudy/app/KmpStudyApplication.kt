package evgeny.fetskovich.kmpstudy.app

import android.app.Application
import evgeny.fetskovich.kmpstudy.app.di.sharedAndroidModule
import org.koin.core.context.startKoin

class KmpStudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                sharedAndroidModule(
                    application = this@KmpStudyApplication
                )
            )
        }
    }
}