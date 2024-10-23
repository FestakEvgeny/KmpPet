package evgeny.fetskovich.kmpstudy.app.ui.screens.signup

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInScreen
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInViewModel
import org.koin.compose.koinInject

class SignUpNavigation : Screen {

    @Composable
    override fun Content() {
        val viewModel: SignUpViewModel = koinInject()

        SignUpScreen(
            viewModel = viewModel,
        )
    }
}