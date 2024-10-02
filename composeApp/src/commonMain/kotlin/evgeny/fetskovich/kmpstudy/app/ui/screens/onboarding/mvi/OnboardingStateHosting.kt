package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.StateHosting
import kotlinx.coroutines.flow.update

class OnboardingStateHosting : StateHosting<OnboardingScreenState>() {

    fun updateScreenPage(
        page: Int
    ) {
        _screenState.update {
            it.copy(
                currentPage = page,
            )
        }
    }

    override fun createInitialState(): OnboardingScreenState = OnboardingScreenState()
}
