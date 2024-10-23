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
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.button.ActionButton
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.input.AuthorizationInput
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_splash
import fetskovichkmppet.composeapp.generated.resources.sign_in_continue_with
import fetskovichkmppet.composeapp.generated.resources.sign_in_forgot_password
import fetskovichkmppet.composeapp.generated.resources.sign_in_login_btn
import fetskovichkmppet.composeapp.generated.resources.sign_in_password_hint
import fetskovichkmppet.composeapp.generated.resources.sign_in_title
import fetskovichkmppet.composeapp.generated.resources.sign_in_username_hint
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignInScreen (
    viewModel: SignInViewModel
) {
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
            text = stringResource(Res.string.sign_in_title),
            color = KmpTheme.colors.textColors.baseTextColor,
            style = KmpTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
            )
        )

        AuthorizationInput(
            input = state.username,
            placeholder = stringResource(Res.string.sign_in_username_hint),
            isSaveField = false,
            onValueUpdate = {
                userEventProcessor.processEvent(SignInUserEvent.UpdateUsername(it))
            },
            leftIcon = Res.drawable.ic_splash,
        )

        AuthorizationInput(
            input = state.password,
            placeholder = stringResource(Res.string.sign_in_password_hint),
            isSaveField = false,
            onValueUpdate = {
                userEventProcessor.processEvent(SignInUserEvent.UpdatePassword(it))
            },
            leftIcon = Res.drawable.ic_splash,
        )

        Text(
            text = stringResource(Res.string.sign_in_forgot_password),
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
        )

        ActionButton(
            text = stringResource(Res.string.sign_in_login_btn),
            onClick = {
                userEventProcessor.processEvent(SignInUserEvent.Login)
            }
        )

        Spacer(Modifier.height(70.dp))

        Text(
            text = stringResource(Res.string.sign_in_continue_with),
        )


    }
}