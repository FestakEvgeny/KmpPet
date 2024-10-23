package evgeny.fetskovich.kmpstudy.app.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import cafe.adriel.voyager.navigator.LocalNavigator
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.OnboardingNavigation
import evgeny.fetskovich.kmpstudy.app.ui.screens.signin.SignInNavigation
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.mvi.SplashScreenNavigation
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.ic_splash
import fetskovichkmppet.composeapp.generated.resources.splash_title
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen(
    viewModel: SplashViewModel
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val navigator = LocalNavigator.current

    Screen()

    LaunchedEffect(Unit) {
        viewModel.setup()
    }

    LaunchedEffect(Unit) {
        launch {
            viewModel.navigationResult
                .flowWithLifecycle(lifecycleOwner.lifecycle, Lifecycle.State.RESUMED)
                .map { it as SplashScreenNavigation }
                .collectLatest { navigation ->
                    when (navigation) {
                        SplashScreenNavigation.OpenMainScreen -> {
                            // TODO
                        }
                        SplashScreenNavigation.OpenOnboarding -> {
                            navigator?.push(OnboardingNavigation())
                        }

                        SplashScreenNavigation.OpenLoginScreen -> {
                            navigator?.push(SignInNavigation())
                        }
                    }
                }
        }
    }
}

@Composable
private fun Screen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_splash),
                contentDescription = "logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(125.dp)
            )

            Spacer(Modifier.width(9.dp))

            // TODO Apply black border instead
            Text(
                text = stringResource(Res.string.splash_title),
                color = AppColors.primary,
                style = KmpTheme.typography.titleLarge.copy(
                    fontSize = 40.sp,
                    drawStyle = Stroke(
                        miter = 10f,
                        width = 5f,
                        join = StrokeJoin.Round,
                    )
                ),
            )
        }
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    AppTheme {
        Screen()
    }
}