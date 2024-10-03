package evgeny.fetskovich.kmpstudy.app.ui.theme.colors

import androidx.compose.ui.graphics.Color

object AppColors {

    val primary = Color(0xFFF83758)
    val white = Color(0xFFFFFFFF)
    val pink = Color(0xFFF83758)
    val black = Color(0xFF000000)
    val brightGray = Color(0xFFC4C4C4)
    val lightGray = Color(0xFFA8A8A9)
    val darkGray = Color(0xFFA0A0A1)

    val registrationInputText = Color(0xFF676767)
    val authorizationBorder = Color(0xFFF3F3F3)
    val authorizationIcon = Color(0xFF626262)

    val selectedIndicator = Color(0xFF17223B)
    val unselectedIndicator = selectedIndicator.copy(
        alpha = 0.2f,
    )

    val error = Color(0xFFFF0000)
}