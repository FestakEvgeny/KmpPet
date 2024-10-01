package evgeny.fetskovich.kmpstudy.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import evgeny.fetskovich.kmpstudy.app.ui.screens.splash.SplashScreen
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataIntent
import evgeny.fetskovich.kmpstudy.domain.usecase.initial.SetupInitialDataUseCase
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.flow.collectLatest

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }

        SplashScreen()
    }
}