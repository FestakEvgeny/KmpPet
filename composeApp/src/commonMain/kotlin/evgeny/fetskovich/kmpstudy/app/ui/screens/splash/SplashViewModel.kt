package evgeny.fetskovich.kmpstudy.app.ui.screens.splash

import androidx.lifecycle.viewModelScope
import evgeny.fetskovich.kmpstudy.app.ui.base.viewmodel.BaseViewModel
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.mvi.SplashScreenNavigation
import evgeny.fetskovich.kmpstudy.domain.coroutines.CoroutineContextProvider
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

private const val SPLASH_DELAY = 500L

class SplashViewModel(
    private val setupInitialDataUseCase: SetupInitialDataUseCase,
    coroutineDispatcher: CoroutineContextProvider,
) : BaseViewModel(coroutineDispatcher) {

    fun setup() {
        viewModelScope.launch(Dispatchers.IO) {
            setupInitialDataUseCase.execute(SetupInitialDataIntent())
                .onEach {
                    delay(SPLASH_DELAY)
                }
                .collectLatest {
                    sendNavigation(SplashScreenNavigation.OpenOnboarding)
                }
        }
    }
}