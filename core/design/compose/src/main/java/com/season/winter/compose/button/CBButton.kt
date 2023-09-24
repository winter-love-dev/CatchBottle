package com.season.winter.compose.button

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.button.CBButtonStyleCompose
import com.season.winter.designsystem.typography.CBTypography

@Composable
fun CBButton(
    text: String = "",
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier.fillMaxWidth(),
    style: CBButtonStyleCompose = CBButtonStyleCompose.First,
    enabled: Boolean = true,
    onClick: (() -> Unit),
) {
    val colorFromDesignSystem = ButtonDefaults.buttonColors(
        containerColor = style.enableBackgroundColor,
        contentColor = style.enableTextColor,
        disabledContainerColor = style.disableBackgroundColor,
        disabledContentColor = style.disableTextColor,
    )
    val styleChange by remember {
        mutableStateOf(colorFromDesignSystem)
    }
    val enabledChange by remember {
        mutableStateOf(enabled)
    }
    Button(
        modifier = modifier,
        colors = styleChange,
        content = @Composable {
            Row {
                // add leading component ...
                CBText(
                    softWrap = false, // 줄바꿈 되지 않게
                    type = CBTypography.CaptionM,
                    text = text
                )
                // add trailing component ...
            }
        },
        enabled = enabledChange,
        onClick = onClick,
    )
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewCBButton() {
    ComposeCatchBottleTheme {
        Column {
            CBButton("this component is 'CBButton'") { }
            CBButton("아래처럼 텍스트가 끝에 닿으면 영역을 벗어나게 됩니다") { }
            CBButton("abcdefghijklmnopopqrstuvwxyzABCDEFGHIJKLMNOPOPQRSTUVWXYZ") { }
            CBButton("가나다라마바사아자차카타파하가나다라마바사아자차카타파하") { }
            CBButton(
                "this style is 'CBButtonStyleCompose.First'"
            ) { }
            CBButton(
                "this is disable state 'CBButtonStyleCompose.First'",
                enabled = false
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Second'",
                style = CBButtonStyleCompose.Second
            ) { }
            CBButton(
                "this is disable state 'CBButtonStyleCompose.Second'",
                style = CBButtonStyleCompose.Second,
                enabled = false
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Third'",
                style = CBButtonStyleCompose.Third
            ) { }
            CBButton(
                "this is disable state 'CBButtonStyleCompose.Third'",
                style = CBButtonStyleCompose.Third,
                enabled = false
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Ghost'",
                style = CBButtonStyleCompose.Ghost
            ) { }
            CBButton(
                "this is disable state 'CBButtonStyleCompose.Ghost'",
                style = CBButtonStyleCompose.Ghost,
                enabled = false
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Negative'",
                style = CBButtonStyleCompose.Negative
            ) { }
            CBButton(
                "this is disable state 'CBButtonStyleCompose.Negative'",
                style = CBButtonStyleCompose.Negative,
                enabled = false
            ) { }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                CBButton(
                    modifier = Modifier.weight(1f),
                    style = CBButtonStyleCompose.Second,
                    text = "Left"
                ) { }
                Spacer(modifier = Modifier.width(6.dp))
                CBButton(
                    modifier = Modifier.weight(1f),
                    text = "Right"
                ) { }
            }
            Row(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                CBButton(
                    modifier = Modifier.weight(1f),
                    style = CBButtonStyleCompose.Negative,
                    text = "No"
                ) { }
                Spacer(modifier = Modifier.width(8.dp))
                CBButton(
                    modifier = Modifier.weight(1f),
                    text = "Yes"
                ) { }
            }
        }
    }
}