package com.season.winter.compose.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.typography.CBTypography

@Composable
fun CBText(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    type: CBTypography = CBTypography.BodyM,
    textAlign: TextAlign? = null,
    softWrap: Boolean = true,
    text: String
) {
    
    val valueChange by remember {
        mutableStateOf(text)
    }

    Text(
        modifier = modifier,
        text = valueChange,
        style = style.copy(
            lineBreak = LineBreak.Simple
        ),
        softWrap = softWrap,
        textAlign = textAlign,
        fontFamily = FontFamily(Font(type.fontFamily)),
        fontWeight = type.weightCompose,
        fontSize = type.sizeCompose ?: 16.sp,
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewCBText() {
    ComposeCatchBottleTheme {
        Column {
            val text = "this is 'CBText' made in 'Design System, CatchBottle'"
            CBText(
                Modifier.padding(16.dp),
                text = text
            )

            CBText(
                type = CBTypography.CaptionS,
                text = "this is 'CBTypography.CaptionS'"
            )
            CBText(
                type = CBTypography.CaptionM,
                text = "this is 'CBTypography.CaptionM'"
            )
            CBText(
                type = CBTypography.BodyS,
                text = "this is 'CBTypography.BodyS'"
            )
            CBText(
                type = CBTypography.BodyM,
                text = "this is 'CBTypography.BodyM'"
            )
            CBText(
                type = CBTypography.BodyL,
                text = "this is 'CBTypography.BodyL'"
            )
            CBText(
                type = CBTypography.HeadXs,
                text = "this is 'CBTypography.HeadXs'"
            )
            CBText(
                type = CBTypography.HeadS,
                text = "this is 'CBTypography.HeadS'"
            )
            CBText(
                type = CBTypography.HeadM,
                text = "this is 'CBTypography.HeadM'"
            )
            CBText(
                type = CBTypography.HeadL,
                text = "this is 'CBTypography.HeadL'"
            )
            CBText(
                type = CBTypography.HeadL,
                text = "가나다라마바사아자차카타파하 가나다라마바사아자차카타파하"
            )
            CBText(
                type = CBTypography.HeadL,
                text = "가나다라마바사아자차카타파하가나다라마바사아자차카타파하"
            )
        }
    }
}
