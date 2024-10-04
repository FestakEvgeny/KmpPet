package evgeny.fetskovich.kmpstudy.app.di.data

import evgeny.fetskovich.kmpstudy.data.repository.user.UserRepositoryImpl
import evgeny.fetskovich.kmpstudy.domain.repository.UserRepository
import org.koin.dsl.module

fun dataModule(isDebug: Boolean) = module {

    single<UserRepository> { UserRepositoryImpl() }
}
