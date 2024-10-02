package evgeny.fetskovich.kmpstudy.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.LocalAppColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.ThemedColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.appColors
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.palettes.AppColorPalette
import evgeny.fetskovich.kmpstudy.app.ui.theme.typography.AppTypography
import evgeny.fetskovich.kmpstudy.app.ui.theme.typography.LocalAppTypographies

object KmpTheme {

    val colors: ThemedColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypographies.current
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    palette: AppColorPalette = AppColorPalette.PINK,
    content: @Composable () -> Unit
) {
    val colors = appColors(palette = palette, isDarkTheme = false)

    CompositionLocalProvider(
        LocalAppColors provides colors,
    ) {
        MaterialTheme(
            colorScheme = colors.materialColors,
            typography = KmpTheme.typography.materialTypography,
            content = content,
        )
    }
}