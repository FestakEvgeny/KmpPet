package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.MockUserEventProcessor
import evgeny.fetskovich.kmpstudy.app.architecture.mvi.UserEventProcessor
import evgeny.fetskovich.kmpstudy.app.ui.modifiers.cleanClickable
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingUserEvent
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.onboarding_header_skip
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingHeader(
    currentPage: Int,
    totalPages: Int,
    userEventProcessor: UserEventProcessor,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
    ) {
        val string = buildAnnotatedString {
            pushStyle(
                SpanStyle(
                    color = AppColors.black
                )
            )
            append(currentPage.toString())
            pushStyle(
                SpanStyle(
                    color = AppColors.darkGray
                )
            )
            append("/$totalPages")
        }

        Text(
            text = string,
            style = KmpTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = stringResource(Res.string.onboarding_header_skip),
            style = KmpTheme.typography.bodyLarge,
            color = KmpTheme.colors.textColors.baseTextColor,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .cleanClickable {
                    userEventProcessor.processEvent(OnboardingUserEvent.CloseOnboarding)
                }
        )
    }
}

@Preview
@Composable
private fun OnboardingHeaderPreview() {
    AppTheme {
        OnboardingHeader(
            currentPage = 1,
            totalPages = 3,
            userEventProcessor = MockUserEventProcessor,
        )
    }
}