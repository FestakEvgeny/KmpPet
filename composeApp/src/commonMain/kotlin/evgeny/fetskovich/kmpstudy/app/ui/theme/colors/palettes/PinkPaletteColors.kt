package evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
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
        baseTextColor = AppColors.black,
        textColorSecondary = AppColors.gray,
        errorTextColor = AppColors.pink,
    ),
)

private val darkPalette = lightPalette