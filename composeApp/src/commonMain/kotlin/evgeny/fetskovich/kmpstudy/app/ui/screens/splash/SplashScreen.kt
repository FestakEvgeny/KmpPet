package evgeny.fetskovich.kmpstudy.app.ui.screens.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject

@Composable
fun SplashScreen() {
    val viewModel: SplashViewModel = koinInject()

    Column {
        Spacer(Modifier.height(100.dp))
        Text("Текст")
    }

    LaunchedEffect(Unit) {
        viewModel.setup()
    }
}