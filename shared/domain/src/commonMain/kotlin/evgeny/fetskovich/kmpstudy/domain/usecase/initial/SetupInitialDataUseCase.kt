package evgeny.fetskovich.kmpstudy.domain.usecase.initial

import evgeny.fetskovich.kmpstudy.domain.usecase.UseCase
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.UseCaseResult
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SetupInitialDataUseCase : UseCase<SetupInitialDataIntent, SetupInitialDataResult>{

    override fun execute(
        intent: SetupInitialDataIntent
    ): Flow<SetupInitialDataResult> = flow {
        println("JEKA Start")
        delay(500L)
        println("JEKA End")
        emit(SetupInitialDataResult.Completed)
    }
}

class SetupInitialDataIntent : UseCaseIntent

sealed interface SetupInitialDataResult : UseCaseResult {

    data object Completed : SetupInitialDataResult
}