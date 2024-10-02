package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi

import evgeny.fetskovich.kmpstudy.app.architecture.mvi.ScreenState
import kotlinx.collections.immutable.PersistentList
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class OnboardingScreenState(
    val currentPage: Int = 0,
    val prevButtonText: StringResource?,
    val nextButtonText: StringResource,
    val onboardingPages: PersistentList<OnboardingPage>,
    val pageIndication: String = "${currentPage + 1}/${onboardingPages.size}",
) : ScreenState

data class OnboardingPage(
    val image: DrawableResource,
    val title: StringResource,
    val message: StringResource,
)
