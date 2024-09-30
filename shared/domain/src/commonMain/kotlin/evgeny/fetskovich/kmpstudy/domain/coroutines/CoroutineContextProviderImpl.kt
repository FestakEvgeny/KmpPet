package evgeny.fetskovich.kmpstudy.domain.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class CoroutineContextProviderImpl : CoroutineContextProvider {

    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
    override val mainImmediate: CoroutineDispatcher = Dispatchers.Main.immediate
    override val main: CoroutineDispatcher = Dispatchers.Main
}
