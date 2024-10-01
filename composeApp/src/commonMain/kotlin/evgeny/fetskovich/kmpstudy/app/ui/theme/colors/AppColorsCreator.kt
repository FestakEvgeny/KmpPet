package evgeny.fetskovich.kmpstudy.app.ui.theme.colors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes.AppColorPalette
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes.pinkAppColors

val LocalAppColors = staticCompositionLocalOf {
    defaultColors()
}

private fun defaultColors() = pinkAppColors(isDark = false)

@Composable
internal fun appColors(
    palette: AppColorPalette,
    isDarkTheme: Boolean
): ThemedColors = when (palette) {
    AppColorPalette.PINK -> pinkAppColors(isDarkTheme)
}
