package evgeny.fetskovich.kmpstudy.app.ui.theme.elements.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ActionButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    width: Dp = Dp.Unspecified,
    height: Dp = 44.dp,
    isEnabled: Boolean = true,
    borderStroke: BorderStroke? = null,
    shape: Shape = RoundedCornerShape(6.dp),
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        containerColor = AppColors.primary,
        disabledContainerColor = AppColors.primary,
        contentColor = AppColors.white,
        disabledContentColor = AppColors.white,
    )
) {
    Button(
        onClick = onClick,
        shape = shape,
        modifier = modifier
            .height(height)
            .width(width)
            .fillMaxWidth(),
        border = borderStroke,
        colors = colors,
        enabled = isEnabled
    ) {
        Text(
            text = text,
            style = KmpTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}

@Preview
@Composable
private fun KomusActionButtonEnabledPreview() {
    AppTheme {
        ActionButton(
            onClick = {},
            text = "Да",
            isEnabled = true,
        )
    }
}

@Preview
@Composable
private fun KomusActionButtonDisabledPreview() {
    AppTheme {
        ActionButton(
            onClick = {},
            text = "Да",
            isEnabled = false,
        )
    }
}

@Preview
@Composable
private fun KomusActionButtonCustomColorsPreview() {
    AppTheme {
        ActionButton(
            onClick = {},
            text = "Да",
        )
    }
}
