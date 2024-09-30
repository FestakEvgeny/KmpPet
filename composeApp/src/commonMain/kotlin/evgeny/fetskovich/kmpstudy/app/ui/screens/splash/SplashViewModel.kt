package evgeny.fetskovich.kmpstudy.app.ui.screens.splash

import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SplashViewModel (
    private val setupInitialDataUseCase: SetupInitialDataUseCase
) : BaseViewModel() {

    fun setup() {
        viewModelScope.launch (Dispatchers.IO) {
            setupInitialDataUseCase.execute(SetupInitialDataIntent())
                .collectLatest {
                    println("JEKA Received result in view model $it")
                }
        }
    }
}