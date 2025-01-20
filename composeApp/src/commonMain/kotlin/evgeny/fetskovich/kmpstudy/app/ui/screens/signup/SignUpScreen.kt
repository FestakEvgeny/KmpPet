package evgeny.fetskovich.kmpstudy.app.ui.screens.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.extensions.collectNavigation
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.authorizationScreenModifier
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInNavigationEvent
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi.SignUpScreenState
import evgeny.fetskovich.kmpstudy.app.ui.screens.signup.mvi.SignUpUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.button.ActionButton
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.input.AuthorizationInput
import evgeny.fetskovich.kmpstudy.app.ui.theme.typography.TextSizes
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_password_lock
import fetskovichkmppet.composeapp.generated.resources.ic_user
import fetskovichkmppet.composeapp.generated.resources.sign_up_additional_text
import fetskovichkmppet.composeapp.generated.resources.sign_up_already_have_account
import fetskovichkmppet.composeapp.generated.resources.sign_up_confirm_password_hint
import fetskovichkmppet.composeapp.generated.resources.sign_up_create_account
import fetskovichkmppet.composeapp.generated.resources.sign_up_login
import fetskovichkmppet.composeapp.generated.resources.sign_up_password_hint
import fetskovichkmppet.composeapp.generated.resources.sign_up_title
import fetskovichkmppet.composeapp.generated.resources.sign_up_username_hint
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
) {
    val state by viewModel.screenState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current
    val navigator = LocalNavigator.current

    Screen(
        state = state,
        userEventProcessor = viewModel,
    )

    LaunchedEffect(Unit) {
        viewModel.collectNavigation<SignInNavigationEvent>(
            lifecycleOwner = lifecycleOwner,
            scope = this
        ) { navigation ->
            when (navigation) {
                SignInNavigationEvent.NavigateBack -> navigator?.pop()
                SignInNavigationEvent.ToSignUp -> navigator?.push(SignUpNavigation())
            }
        }
    }
}

@Composable
private fun Screen(
    state: SignUpScreenState,
    userEventProcessor: UserEventProcessor,
) {
    Column(
        modifier = authorizationScreenModifier
    ) {

        Text(
            text = stringResource(Res.string.sign_up_title),
            color = KmpTheme.colors.textColors.baseTextColor,
            style = KmpTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
            )
        )

        Spacer(Modifier.height(46.dp))

        AuthorizationInput(
            input = state.username,
            placeholder = stringResource(Res.string.sign_up_username_hint),
            isSaveField = false,
            onValueUpdate = {
                userEventProcessor.processEvent(SignUpUserEvent.UpdateUsername(it))
            },
            leftIcon = Res.drawable.ic_user,
        )

        Spacer(Modifier.height(30.dp))

        AuthorizationInput(
            input = state.password,
            placeholder = stringResource(Res.string.sign_up_password_hint),
            isSaveField = true,
            onValueUpdate = {
                userEventProcessor.processEvent(SignUpUserEvent.UpdatePassword(it))
            },
            leftIcon = Res.drawable.ic_password_lock,
        )

        Spacer(Modifier.height(30.dp))

        AuthorizationInput(
            input = state.confirmPassword,
            placeholder = stringResource(Res.string.sign_up_confirm_password_hint),
            isSaveField = true,
            onValueUpdate = {
                userEventProcessor.processEvent(SignUpUserEvent.UpdateConfirmPassword(it))
            },
            leftIcon = Res.drawable.ic_password_lock,
        )

        Spacer(Modifier.height(9.dp))

        Text(
            text = stringResource(Res.string.sign_up_additional_text),
            textAlign = TextAlign.Start,
            color = AppColors.primary,
            style = KmpTheme.typography.labelMedium,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(Modifier.height(52.dp))

        ActionButton(
            text = stringResource(Res.string.sign_up_create_account),
            onClick = {
                userEventProcessor.processEvent(SignInUserEvent.SignUp)
            },
        )

        Spacer(Modifier.height(70.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(Res.string.sign_up_already_have_account),
                style = KmpTheme.typography.bodySmall,
            )

            Text(
                text = stringResource(Res.string.sign_up_login),
                style = KmpTheme.typography.titleSmall.copy(
                    fontSize = TextSizes.small,
                ),
                color = AppColors.primary,
                modifier = Modifier
                    .clickable {
                        userEventProcessor.processEvent(SignInUserEvent.Login)
                    }
                    .padding(
                        start = 4.dp,
                    )
            )
        }
    }
}