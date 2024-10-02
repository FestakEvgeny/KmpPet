package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.onboarding_header_skip
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingHeader(
    pageIndicator: String,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = pageIndicator,
            style = KmpTheme.typography.bodyLarge,
        )

        Text(
            text = stringResource(Res.string.onboarding_header_skip),
            style = KmpTheme.typography.bodyLarge,
            color = KmpTheme.colors.textColors.baseTextColor,
        )
    }
}

@Preview
@Composable
private fun OnboardingHeaderPreview() {
    AppTheme {
        OnboardingHeader(
            pageIndicator = "2/3",
        )
    }
}