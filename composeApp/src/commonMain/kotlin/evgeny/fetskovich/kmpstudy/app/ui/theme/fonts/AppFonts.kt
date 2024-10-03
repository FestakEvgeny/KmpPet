package evgeny.fetskovich.kmpstudy.app.ui.theme.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.fira_sans
import fetskovichkmppet.composeapp.generated.resources.fira_sans_medium
import fetskovichkmppet.composeapp.generated.resources.fira_sans_semibold
import org.jetbrains.compose.resources.Font

object AppFonts {

    val firaSans: FontFamily
        @Composable get() = FontFamily(
            Font(resource = Res.font.fira_sans),
            Font(resource = Res.font.fira_sans, style = FontStyle.Italic),
            Font(resource = Res.font.fira_sans_medium, weight = FontWeight.Medium),
            Font(resource = Res.font.fira_sans_medium, weight = FontWeight.Medium, style = FontStyle.Italic),
            Font(resource = Res.font.fira_sans_semibold, weight = FontWeight.Bold),
            Font(resource = Res.font.fira_sans_semibold, weight = FontWeight.Bold, style = FontStyle.Italic)
        )
}
