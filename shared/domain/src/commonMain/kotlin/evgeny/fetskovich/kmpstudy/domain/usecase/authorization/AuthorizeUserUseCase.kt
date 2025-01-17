package evgeny.fetskovich.kmpstudy.domain.usecase.authorization

import evgeny.fetskovich.kmpstudy.domain.repository.UserRepository
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCase
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class AuthorizeUserUseCase(
    private val userRepository: UserRepository,
) : UseCase<AuthorizeUserIntent, AuthorizeUserResult> {

    override fun execute(
        intent: AuthorizeUserIntent
    ): Flow<AuthorizeUserResult> = userRepository.authorizeUser(
        login = intent.name,
        password = intent.password
    ).map {
        AuthorizeUserResult.Success
    }.catch { error ->
        AuthorizeUserResult.Error(error)
    }
}

class AuthorizeUserIntent(
    val name: String,
    val password: String
) : UseCaseIntent

sealed interface AuthorizeUserResult : UseCaseResult {

    data object Success : AuthorizeUserResult

    data class Error(
        val throwable: Throwable
    ) : AuthorizeUserResult
}
