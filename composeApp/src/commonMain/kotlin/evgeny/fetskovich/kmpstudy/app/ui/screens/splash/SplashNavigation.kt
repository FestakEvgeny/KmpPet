package evgeny.fetskovich.kmpstudy.app.ui.screens.splash

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject

class SplashNavigation : Screen {

    @Composable
    override fun Content() {
        val viewModel: SplashViewModel = koinInject()

        SplashScreen(
            viewModel = viewModel,
        )
    }
}