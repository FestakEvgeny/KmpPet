package evgeny.fetskovich.kmpstudy.domain.usecase

import kotlinx.coroutines.flow.Flow

interface UseCase<I : UseCaseIntent, R : UseCaseResult> {

    fun execute(intent: I): Flow<R>
}
