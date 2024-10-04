package evgeny.fetskovich.kmpstudy.domain.repository

import evgeny.fetskovich.kmpstudy.domain.entity.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface UserRepository {

    fun observeUser(): StateFlow<User?>

    fun authorizeUser(
        login: String,
        password: String
    ): Flow<Boolean>

    fun logout(): Flow<Boolean>
}
