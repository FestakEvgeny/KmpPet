package evgeny.fetskovich.kmpstudy.data.repository.user

import evgeny.fetskovich.kmpstudy.domain.entity.user.User
import evgeny.fetskovich.kmpstudy.domain.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update

class UserRepositoryImpl : UserRepository {

    private val _userState: MutableStateFlow<User?> = MutableStateFlow(null)
    private val userState = _userState.asStateFlow()

    override fun observeUser(): StateFlow<User?> = userState

    override fun authorizeUser(
        login: String,
        password: String
    ): Flow<Boolean> = flow {
        delay(500L)
        // TODO Store user data
        _userState.update {
            User(
                username = login,
            )
        }

        emit(true)
    }

    override fun logout(): Flow<Boolean> = flow {
        delay(500L)
        _userState.update { null }
        emit(true)
    }
}