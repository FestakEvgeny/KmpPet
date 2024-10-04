package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInScreenState
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.button.ActionButton
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.input.AuthorizationInput
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_splash
import org.koin.compose.koinInject

@Composable
fun SignInScreen () {
    val viewModel: SignInViewModel = koinInject()
    val state by viewModel.screenState.collectAsState()

    Screen(
        state = state,
        userEventProcessor = viewModel,
    )
}

@Composable
private fun Screen(
    state: SignInScreenState,
    userEventProcessor: UserEventProcessor,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {

        Text(
            text = "Welcome\nBack!",
            color = KmpTheme.colors.textColors.baseTextColor,
            style = KmpTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
            )
        )

        AuthorizationInput(
            input = state.username,
            placeholder = "Username or Email",
            isSaveField = false,
            onValueUpdate = {},
            leftIcon = Res.drawable.ic_splash,
        )

        AuthorizationInput(
            input = state.password,
            placeholder = "Password",
            isSaveField = false,
            onValueUpdate = {},
            leftIcon = Res.drawable.ic_splash,
        )

        Text(
            text = "Forgot password?",
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )

        ActionButton(
            text = "Login",
            onClick = {

            }
        )

        Spacer(Modifier.height(70.dp))

        Text(
            text = "OR"
        )


    }
}