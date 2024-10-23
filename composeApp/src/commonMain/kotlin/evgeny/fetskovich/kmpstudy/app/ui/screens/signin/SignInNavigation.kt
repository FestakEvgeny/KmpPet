package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.koinInject

class SignInNavigation  : Screen {

    @Composable
    override fun Content() {
        val viewModel: SignInViewModel = koinInject()

        SignInScreen(
            viewModel = viewModel,
        )
    }
}