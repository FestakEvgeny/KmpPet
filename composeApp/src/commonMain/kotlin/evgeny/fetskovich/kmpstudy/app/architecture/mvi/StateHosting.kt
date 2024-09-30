package evgeny.fetskovich.kmpstudy.app.architecture.mvi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class StateHosting<T: ScreenState> {

    protected val _screenState = MutableStateFlow(createInitialState())
    val screenState: StateFlow<T> = _screenState.asStateFlow()

    protected abstract fun createInitialState(): T
}