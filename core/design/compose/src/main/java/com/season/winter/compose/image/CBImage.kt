package com.season.winter.compose.image

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.graphic.CBGraphic
import com.season.winter.designsystem.size.CBSize
import com.season.winter.designsystem.spacing.CBSpacing

@Composable
fun CBImage(
    painter: Painter,
    size: CBSize = CBSize.X2l,
    width: Dp? = null,
    height: Dp? = null,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    alpha: Float = DefaultAlpha,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
) {
    Image(
        painter = painter,
        modifier = modifier
            .width(width ?: size.dp)
            .height(height ?: size.dp)
        ,
        contentDescription = contentDescription,
        contentScale = contentScale,
        alignment = alignment,
        alpha = alpha,
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

            CBText(text = "CBSize.Xl")
            CBImage(
                painter = CBGraphic.LogoIcon.painter,
                size = CBSize.Xl,
            )

            CBText(text = "CBSize.X2l")
            CBImage(
                painter = CBGraphic.LogoIcon.painter,
                size = CBSize.X2l,
            )

            CBText(text = "CBSize.X3l")
            CBImage(
                painter = CBGraphic.LogoIcon.painter,
                size = CBSize.X3l,
            )

            CBText(text = "CBSize.X4l")
            CBImage(
                painter = CBGraphic.LogoIcon.painter,
                size = CBSize.X4l,
            )
        }
    }
}