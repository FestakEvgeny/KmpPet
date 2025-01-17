package evgeny.fetskovich.kmpstudy.app.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.Navigation
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch

inline fun <reified T : Navigation> BaseViewModel.collectNavigation(
    lifecycleOwner: LifecycleOwner,
    scope: CoroutineScope,
    crossinline processEvent: (T) -> Unit,
) {
    scope.launch {
        navigationResult
            .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
            .filterIsInstance<T>()
            .collectLatest { navigation ->
                processEvent(navigation)
            }
    }
}
