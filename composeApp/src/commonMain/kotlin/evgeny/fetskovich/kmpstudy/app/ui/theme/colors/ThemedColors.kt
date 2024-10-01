package evgeny.fetskovich.kmpstudy.app.ui.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class ThemedColors (
    val materialColors: ColorScheme,
    val textColors: AppTextColors,
) {

    val primary = materialColors.primary
    val onPrimary = materialColors.onPrimary
    val secondary = materialColors.secondary
    val onSecondary = materialColors.onSecondary
    val background = materialColors.background
    val surface = materialColors.surface
    val error = materialColors.error
    val onBackground = materialColors.onBackground
    val onSurface = materialColors.onSurface
    val onError = materialColors.onError
}

data class AppTextColors(
    val baseTextColor: Color,
    val textColorSecondary: Color,
    val errorTextColor: Color,
)