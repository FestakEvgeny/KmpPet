package evgeny.fetskovich.kmpstudy.app.ui.theme.elements.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import evgeny.fetskovich.kmpstudy.app.ui.theme.AppTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.KmpTheme
import evgeny.fetskovich.kmpstudy.app.ui.theme.colors.AppColors
import evgeny.fetskovich.kmpstudy.app.validation.ValidationField
import fetskovichkmppet.composeapp.generated.resources.Res
import fetskovichkmppet.composeapp.generated.resources.compose_multiplatform
import fetskovichkmppet.composeapp.generated.resources.ic_input_eye
import fetskovichkmppet.composeapp.generated.resources.ic_password_lock
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AuthorizationInput(
    input: ValidationField,
    placeholder: String,
    isSaveField: Boolean,
    onValueUpdate: (String) -> Unit,
    leftIcon: DrawableResource,
    modifier: Modifier = Modifier,
) {

    val textInputColors = KmpTheme.colors.authorizationInputLayoutColors

    var showPassword by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    BorderStroke(
                        width = 1.dp,
                        color = when {
                            input.isValid -> textInputColors.focusedBorderTextColor
                            else -> textInputColors.errorColor
                        }
                    ),
                    RoundedCornerShape(6.dp)
                )
        ) {
            TextField(
                value = input.text,
                textStyle = KmpTheme.typography.bodyMedium,
                onValueChange = { newValue ->
                    onValueUpdate(newValue)
                },
                placeholder = {
                    Text(
                        text = placeholder,
                        color = textInputColors.hintTextColor,
                        style = KmpTheme.typography.labelMedium,
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(leftIcon),
                        tint = AppColors.authorizationIcon,
                        contentDescription = "left icon",
                        modifier = Modifier
                            .size(20.dp)
                    )
                },
                singleLine = true,
                keyboardOptions = if (isSaveField) {
                    KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                } else {
                    KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    )
                },
                visualTransformation = if (isSaveField && showPassword) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                trailingIcon = {
                    if (isSaveField) {
                        PasswordVisibilityToggleIcon(
                            showPassword = showPassword,
                            onTogglePasswordVisibility = { showPassword = !showPassword })
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = textInputColors.backgroundColor,
                    focusedContainerColor = textInputColors.backgroundColor,
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        input.errorMessage?.let {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = it,
                color = KmpTheme.colors.textColors.errorTextColor,
                style = KmpTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
private fun PasswordVisibilityToggleIcon(
    showPassword: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {
    val image = if (showPassword) {
        Res.drawable.ic_password_lock
    } else {
        Res.drawable.ic_input_eye
    }

    // IconButton to toggle password visibility
    IconButton(onClick = onTogglePasswordVisibility) {
        Icon(
            painter = painterResource(image),
            contentDescription = "Password icon"
        )
    }
}

@Preview
@Composable
private fun AuthorizationInputPreview() {
    AppTheme {
        AuthorizationInput(
            input = ValidationField(
                text = "Test",
                errorMessage = null,
            ),
            placeholder = "Number",
            isSaveField = false,
            onValueUpdate = {},
            leftIcon = Res.drawable.compose_multiplatform,
        )
    }
}


@Preview
@Composable
private fun AuthorizationInputSaveFieldPreview() {
    AppTheme {
        AuthorizationInput(
            input = ValidationField(
                text = "Test",
                errorMessage = null,
            ),
            placeholder = "Number",
            isSaveField = true,
            onValueUpdate = {},
            leftIcon = Res.drawable.compose_multiplatform,
        )
    }
}