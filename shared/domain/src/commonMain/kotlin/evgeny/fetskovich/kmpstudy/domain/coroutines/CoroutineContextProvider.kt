package evgeny.fetskovich.kmpstudy.domain.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineContextProvider {

     val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val mainImmediate: CoroutineDispatcher
    val main: CoroutineDispatcher
}