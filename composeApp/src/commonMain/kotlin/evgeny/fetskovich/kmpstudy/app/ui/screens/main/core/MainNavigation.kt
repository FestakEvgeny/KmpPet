package evgeny.fetskovich.kmpstudy.app.ui.screens.main.core

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject

class MainNavigation : Screen {

    @Composable
    override fun Content() {
        val viewModel: MainViewModel = koinInject()

        MainScreen(
            viewModel = viewModel,
        )
    }
}