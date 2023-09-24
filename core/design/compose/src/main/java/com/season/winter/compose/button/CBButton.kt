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
import androidx.compose.ui.modifier.modifierLocalConsumer
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

    val textChange by remember {
        mutableStateOf(text)
    }

    Button(
        modifier = modifier,
        colors = styleChange,
        content = @Composable {
            Row {
                // leading component ...
                CBText(
                    softWrap = false, // 줄바꿈 되지 않게
                    type = CBTypography.CaptionM,
                    text = textChange
                )
                // trailing component ...
            }
        },
        enabled = enabled,
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
            CBButton("abcdefghijklmnopopqrstuvwxyz") { }
            CBButton("ABCDEFGHIJKLMNOPOPQRSTUVWXYZ") { }
            CBButton("아래처럼 텍스트가 끝에 닿으면 영역을 벗어나게 됩니다") { }
            CBButton("가나다라마바사아자차카타파하가나다라마바사아자차카타파하") { }
            CBButton(
                "this style is 'CBButtonStyleCompose.First'"
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Second'",
                style = CBButtonStyleCompose.Second
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Third'",
                style = CBButtonStyleCompose.Third
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Ghost'",
                style = CBButtonStyleCompose.Ghost
            ) { }
            CBButton(
                text = "this style is 'CBButtonStyleCompose.Negative'",
                style = CBButtonStyleCompose.Negative
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