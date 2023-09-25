package com.season.winter.compose.box

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.season.winter.compose.spacing.cbPadding
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.spacing.CBSpacing
import com.season.winter.designsystem.typography.CBTypography

@Composable
fun CBBox(
    spacing: CBSpacing = CBSpacing.M,
    start: Boolean = false,
    top: Boolean = false,
    end: Boolean = false,
    bottom: Boolean = false,

    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
        .wrapContentSize()
        .cbPadding(
            spacing = spacing,
            start = start,
            top = top,
            end = end,
            bottom = bottom,
        ),

    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier) {
        content()
    }
}

@Composable
fun CBBox(
    spacing: CBSpacing = CBSpacing.M,
    horizontal: Boolean = false,
    vertical: Boolean = false,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier
        .wrapContentSize()
        .cbPadding(
            spacing = spacing,
            horizontal = horizontal,
            vertical = vertical,
        ),

    content: @Composable BoxScope.() -> Unit,
) {
    Box(modifier) {
        content()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewCBText() {
    ComposeCatchBottleTheme {
        Column {

            CBBox {
                CBText(
                    style = CBTypography.HeadM,
                    text = "no padding default box"
                )
            }

            CBBox(
                horizontal = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "padding horizontal"
                )
            }

            CBBox(
                vertical = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "padding vertical"
                )
            }


            CBBox(
                horizontal = true,
                vertical = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading all"
                )
            }

            CBBox(
                start = true,
                top = true,
                end = true,
                bottom = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading all 2"
                )
            }

            CBBox(
                start = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading start"
                )
            }

            CBBox(
                end = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading end"
                )
            }

            CBBox(
                top = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading top"
                )
            }

            CBBox(
                bottom = true,
            ) {
                CBText(
                    style = CBTypography.HeadM,
                    text = "paading bottom"
                )
            }
        }
    }
}