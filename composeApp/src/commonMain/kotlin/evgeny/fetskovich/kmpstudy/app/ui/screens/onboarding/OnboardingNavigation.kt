package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject

class OnboardingNavigation : Screen {

    @Composable
    override fun Content() {
        val viewModel: OnboardingViewModel = koinInject()

        OnboardingScreen(
            viewModel = viewModel,
        )
    }
}