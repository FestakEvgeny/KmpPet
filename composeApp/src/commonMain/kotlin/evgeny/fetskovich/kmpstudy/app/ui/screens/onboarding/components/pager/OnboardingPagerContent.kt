package evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.components.pager

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgeny.fetskovich.kmpstudy.app.ui.screens.onboarding.mvi.OnboardingPage
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.compose_multiplatform
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_text
import fetskovichkmppet.composeapp.generated.resources.onboarding_page_first_title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingPagerContent(
    page: OnboardingPage,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(page.image),
            contentDescription = "onboarding image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .defaultMinSize(
                    minWidth = 300.dp,
                    minHeight = 300.dp,
                )
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = stringResource(page.title),
            style = KmpTheme.typography.titleLarge.copy(
                fontSize = 24.sp,
            ),
            color = KmpTheme.colors.textColors.baseTextColor,
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = stringResource(page.message),
            style = KmpTheme.typography.bodySmall,
            color = KmpTheme.colors.textColors.textColorSecondary,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun OnboardingPagerContentPreview() {
    AppTheme {
        OnboardingPagerContent(
           page = OnboardingPage(
               image = Res.drawable.compose_multiplatform,
               title = Res.string.onboarding_page_first_title,
               message = Res.string.onboarding_page_first_text,
           )
        )
    }
}