package evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.SingleAction
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _navigationResult = Channel<Navigation>()
    val navigationResult = _navigationResult.receiveAsFlow()

    protected val _actionResult = Channel<SingleAction>()
    val actionResult = _navigationResult.receiveAsFlow()

    protected fun sendNavigation(navigation: Navigation) {
        viewModelScope.launch {
            _navigationResult.send(navigation)
        }
    }
    
    protected fun sendAction(action: SingleAction) {
        viewModelScope.launch {
            _actionResult.send(action)
        }
    }
}