package evgeny.fetskovich.kmpstudy.domain.usecase.authorization

import evgeny.fetskovich.kmpstudy.domain.repository.UserRepository
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCase
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class RegisterUserUseCase(
    private val userRepository: UserRepository,
) : UseCase<RegisterUserIntent, RegisterUserResult> {

    override fun execute(
        intent: RegisterUserIntent
    ): Flow<RegisterUserResult> = userRepository.registerUser(
        login = intent.name,
        password = intent.password
    ).map {
        RegisterUserResult.Success
    }.catch { error ->
        RegisterUserResult.Error(error)
    }
}

class RegisterUserIntent(
    val name: String,
    val password: String
) : UseCaseIntent

sealed interface RegisterUserResult : UseCaseResult {

    data object Success : RegisterUserResult

    data class Error(
        val throwable: Throwable
    ) : RegisterUserResult
}
