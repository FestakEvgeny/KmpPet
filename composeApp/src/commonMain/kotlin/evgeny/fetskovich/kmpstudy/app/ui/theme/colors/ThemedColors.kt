package evgeny.fetskovich.kmpstudy.app.ui.theme.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class ThemedColors(
    val materialColors: ColorScheme,
    val textColors: AppTextColors,
    val authorizationInputLayoutColors: TextInputLayoutColors,
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

data class TextInputLayoutColors(
    val focusedTextColor: Color,

    val hintTextColor: Color,
    val hintBorderTextColor: Color,

    val focusedBorderTextColor: Color,

    val errorColor: Color,
)

data class AppTextColors(
    val baseTextColor: Color,
    val textColorSecondary: Color,
    val errorTextColor: Color,
)