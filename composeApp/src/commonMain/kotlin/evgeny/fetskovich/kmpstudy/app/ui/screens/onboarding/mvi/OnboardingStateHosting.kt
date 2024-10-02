package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.StateHosting
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_first_page
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_second_page
import fetskovichkmppet.composeapp.generated.resources.ic_onboarding_third_page
import fetskovichkmppet.composeapp.generated.resources.onboarding_next
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_title
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_second_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_second_title
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_third_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_third_title
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
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

    override fun createInitialState(): OnboardingScreenState = OnboardingScreenState(
        currentPage = 0,
        prevButtonText = null,
        nextButtonText = Res.string.onboarding_next,
        onboardingPages = createOnboardingPages(),
    )

    private fun createOnboardingPages(): PersistentList<OnboardingPage> = persistentListOf(
        OnboardingPage(
            image = Res.drawable.ic_onboarding_first_page,
            title = Res.string.onboarding_page_first_title,
            message = Res.string.onboarding_page_first_text,
        ),
        OnboardingPage(
            image = Res.drawable.ic_onboarding_second_page,
            title = Res.string.onboarding_page_second_title,
            message = Res.string.onboarding_page_second_text,
        ),
        OnboardingPage(
            image = Res.drawable.ic_onboarding_third_page,
            title = Res.string.onboarding_page_third_title,
            message = Res.string.onboarding_page_third_text,
        ),
    )

}
