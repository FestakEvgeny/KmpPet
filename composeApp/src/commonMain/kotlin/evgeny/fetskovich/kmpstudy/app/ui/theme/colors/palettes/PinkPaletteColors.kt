package evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppTextColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.ThemedColors

fun pinkAppColors(isDark: Boolean) = if (isDark) {
    darkPalette
} else {
    lightPalette
}

private val lightPalette = ThemedColors(
    materialColors = lightColorScheme(),
    textColors = AppTextColors(
        baseTextColor = TODO(),
        textColorSecondary = TODO(),
        errorTextColor = TODO(),
    ),
)

private val darkPalette = lightPalette