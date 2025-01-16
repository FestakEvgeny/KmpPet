package evgeny.fetskovich.kmpstudy.app.ui.screens.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.MockUserEventProcessor
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInScreenState
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.mvi.SignInUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.button.ActionButton
import evgeny.fetskovich.kmpstudy.app.ui.theme.elements.input.AuthorizationInput
import evgeny.fetskovich.kmpstudy.app.ui.theme.typography.TextSizes
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_password_lock
import fetskovichkmppet.composeapp.generated.resources.ic_user
import fetskovichkmppet.composeapp.generated.resources.sign_in_create_an_account
import fetskovichkmppet.composeapp.generated.resources.sign_in_forgot_password
import fetskovichkmppet.composeapp.generated.resources.sign_in_login_btn
import fetskovichkmppet.composeapp.generated.resources.sign_in_password_hint
import fetskovichkmppet.composeapp.generated.resources.sign_in_sign_up
import fetskovichkmppet.composeapp.generated.resources.sign_in_title
import fetskovichkmppet.composeapp.generated.resources.sign_in_username_hint
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

val authorizationScreenModifier = Modifier
    .fillMaxSize()
    .statusBarsPadding()
    .navigationBarsPadding()
    .padding(
        top = 19.dp,
        start = 31.dp,
        end = 31.dp,
    )

@Composable
fun SignInScreen(
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
    Column(
        modifier = authorizationScreenModifier
    ) {

        Text(
            text = stringResource(Res.string.sign_in_title),
            color = KmpTheme.colors.textColors.baseTextColor,
            style = KmpTheme.typography.titleLarge.copy(
                fontSize = 36.sp,
            )
        )

        Spacer(Modifier.height(46.dp))

        AuthorizationInput(
            input = state.username,
            placeholder = stringResource(Res.string.sign_in_username_hint),
            isSaveField = false,
            onValueUpdate = {
                userEventProcessor.processEvent(SignInUserEvent.UpdateUsername(it))
            },
            leftIcon = Res.drawable.ic_user,
        )

        Spacer(Modifier.height(30.dp))

        AuthorizationInput(
            input = state.password,
            placeholder = stringResource(Res.string.sign_in_password_hint),
            isSaveField = true,
            onValueUpdate = {
                userEventProcessor.processEvent(SignInUserEvent.UpdatePassword(it))
            },
            leftIcon = Res.drawable.ic_password_lock,
        )

        Spacer(Modifier.height(9.dp))

        Text(
            text = stringResource(Res.string.sign_in_forgot_password),
            textAlign = TextAlign.End,
            color = AppColors.primary,
            style = KmpTheme.typography.labelMedium,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(Modifier.height(52.dp))

        ActionButton(
            text = stringResource(Res.string.sign_in_login_btn),
            onClick = {
                userEventProcessor.processEvent(SignInUserEvent.Login)
            },
        )

        Spacer(Modifier.height(70.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(Res.string.sign_in_create_an_account),
                style = KmpTheme.typography.bodySmall,
            )

            Text(
                text = stringResource(Res.string.sign_in_sign_up),
                style = KmpTheme.typography.titleSmall.copy(
                    fontSize = TextSizes.small,
                ),
                color = AppColors.primary,
                modifier = Modifier
                    .clickable {
                        userEventProcessor.processEvent(SignInUserEvent.SignUp)
                    }
                    .padding(
                        start = 4.dp,
                    )
            )
        }
    }
}

@Preview
@Composable
private fun ScreenEmptyDataPreview() {
    AppTheme {
        Screen(
            state = SignInScreenState(
                username = ValidationField(""),
                password = ValidationField(""),
            ),
            userEventProcessor = MockUserEventProcessor,
        )
    }
}

@Preview
@Composable
private fun ScreenFilledDataPreview() {
    AppTheme {
        Screen(
            state = SignInScreenState(
                username = ValidationField("test@gmail.com"),
                password = ValidationField("123qwe"),
            ),
            userEventProcessor = MockUserEventProcessor,
        )
    }
}