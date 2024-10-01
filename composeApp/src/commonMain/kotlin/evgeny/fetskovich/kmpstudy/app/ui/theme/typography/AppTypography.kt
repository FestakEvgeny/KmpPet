package evgeny.fetskovich.kmpstudy.app.ui.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle


data class AppTypography (
    val materialTypography: Typography,
) {
    val titleLarge: TextStyle = materialTypography.titleLarge
    val titleMedium: TextStyle = materialTypography.titleMedium
    val titleSmall: TextStyle = materialTypography.titleSmall

    val bodyLarge: TextStyle = materialTypography.bodyLarge
    val bodyMedium: TextStyle = materialTypography.bodyMedium
    val bodySmall: TextStyle = materialTypography.bodySmall

    val labelLarge: TextStyle = materialTypography.labelLarge
    val labelMedium: TextStyle = materialTypography.labelMedium
    val labelSmall: TextStyle = materialTypography.labelSmall
}
