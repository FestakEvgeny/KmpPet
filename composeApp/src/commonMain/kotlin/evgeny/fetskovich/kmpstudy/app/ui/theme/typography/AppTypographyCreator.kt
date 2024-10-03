package evgeny.fetskovich.kmpstudy.app.ui.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import evgeny.fetskovich.kmpstudy.app.ui.theme.fonts.AppFonts

val appTypography: AppTypography
    @Composable get() = AppTypography(
        materialTypography = Typography(
            titleLarge = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = TextSizes.xLarge
            ),
            titleMedium = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = TextSizes.large
            ),
            titleSmall = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Bold,
                fontSize = TextSizes.normal
            ),

            bodyLarge = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.large
            ),
            bodyMedium = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.normal
            ),
            bodySmall = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.small
            ),

            labelLarge = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.smaller
            ),

            labelMedium = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.xSmall
            ),

            labelSmall = TextStyle(
                fontFamily = AppFonts.firaSans,
                fontWeight = FontWeight.Normal,
                fontSize = TextSizes.xxSmall
            ),
        )
    )
