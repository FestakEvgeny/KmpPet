package evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes

import androidx.compose.material3.lightColorScheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppTextColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.TextInputLayoutColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.ThemedColors

fun pinkAppColors(isDark: Boolean) = if (isDark) {
    darkPalette
} else {
    lightPalette
}

private val lightPalette = ThemedColors(
    materialColors = lightColorScheme(
        background = AppColors.white,
    ),
    textColors = AppTextColors(
        baseTextColor = AppColors.black,
        textColorSecondary = AppColors.lightGray,
        errorTextColor = AppColors.pink,
    ),
    authorizationInputLayoutColors = TextInputLayoutColors(
        focusedTextColor = AppColors.registrationInputText,
        hintTextColor = AppColors.registrationInputText,
        hintBorderTextColor = AppColors.lightGray,
        focusedBorderTextColor = AppColors.lightGray,
        errorColor = AppColors.error,
        backgroundColor = AppColors.inputBackground
    )
)

private val darkPalette = lightPalette