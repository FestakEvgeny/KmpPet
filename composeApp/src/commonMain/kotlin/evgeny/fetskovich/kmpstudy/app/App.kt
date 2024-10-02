package evgeny.fetskovich.kmpstudy.app

import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.SplashNavigation
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme {
            Navigator(SplashNavigation())
        }
    }
}