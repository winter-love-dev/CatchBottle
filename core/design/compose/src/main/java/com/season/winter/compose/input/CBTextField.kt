package com.season.winter.compose.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.color.CBColor
import com.season.winter.designsystem.typography.CBTypography

@Composable
fun CBTextField(
    modifier: Modifier = Modifier,
    cbTextStyle: CBTypography = CBTypography.CaptionM,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    leadingIcon: @Composable (() -> Unit)? = null,
    useClearIconButton: Boolean = true,
    value: String = "",
    placeholderValue: String = "",
    onValueChange: ((String) -> Unit)? = null
) {

    var valueChange by remember {
        mutableStateOf(value)
    }
    val inputValueIsNotEmpty by remember {
        derivedStateOf { valueChange.isNotEmpty() }
    }
    val textStyle = TextStyle(
        fontFamily = FontFamily(Font(cbTextStyle.fontFamily)),
        fontWeight = cbTextStyle.weightCompose,
        fontSize = cbTextStyle.sizeCompose ?: 16.sp,
    )
    val textFieldStyle = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = CBColor.BrandFirst.color
    )

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        readOnly = readOnly,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        value = valueChange,
        maxLines = maxLines,
        minLines = minLines,
        textStyle = textStyle,
        placeholder = @Composable {
            CBText(
                text = placeholderValue,
                style = cbTextStyle,
                extraStyle = TextStyle(
                    color = Color.LightGray,
                )
            )
        },
        onValueChange = {
            valueChange = it
            onValueChange?.invoke(it)
        },
        leadingIcon = leadingIcon,
        trailingIcon = @Composable {
            if (useClearIconButton && inputValueIsNotEmpty) {
                IconButton(onClick = {
                    valueChange = ""
                    onValueChange?.invoke("")
                }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear",
                    )
                }
            }
        },
        colors = textFieldStyle,
    )
}
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewCBTextField() {
    ComposeCatchBottleTheme {
        Column {
            CBTextField(
                value = "this is basic text field style "
            )

            CBTextField(
                modifier = Modifier.padding(top = 16.dp),
                placeholderValue = "this is place holder"
            )

            CBTextField(
                modifier = Modifier.padding(top = 16.dp),
                value = "this "
            )
        }
    }
}