package com.season.winter.compose.spacing

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.ui.tooling.preview.Preview
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.spacing.CBSpacing

@Composable
fun CBSpacerWidth(
    spacing: CBSpacing = CBSpacing.M,
) {
    Spacer(modifier = Modifier.cbWidth(spacing))
}

@Composable
fun CBSpacerHeight(
    spacing: CBSpacing = CBSpacing.M,
) {
    Spacer(modifier = Modifier.cbHeight(spacing))
}

@Composable
@SuppressLint("ComposableModifierFactory")
fun Modifier.cbWidth(
    spacing: CBSpacing
) = this.width(spacing.dp)


@Composable
@SuppressLint("ComposableModifierFactory")
fun Modifier.cbHeight(
    spacing: CBSpacing = CBSpacing.M,
) = this.height(spacing.dp)

@Composable
fun ColumnScope.CBColumnWeight(
    weight: Float = 1f
) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.CBRowWeight(
    weight: Float = 1f
) {
    Spacer(modifier = Modifier.weight(weight))
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewCBSpacer() {
    ComposeCatchBottleTheme {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            CBSpacerHeight()
            CBText(text = "basic spacer")
            CBSpacerHeight()
            Divider()
            CBText(text = "spacing default width height")
            CBSpacerHeight()
            CBText(text = "spacing default width height")
            Divider()

            CBColumnWeight()

            Row {
                CBText(text = "CBRowWeight")
                CBSpacerWidth()
                CBText(text = "CBRowWeight")
            }

            CBColumnWeight()

            Row {
                CBText(text = "CBRowWeight")
                CBRowWeight()
                CBText(text = "CBRowWeight")
            }

            CBColumnWeight()

            Row {
                CBText(text = "CBRowWeight")
                CBRowWeight()
                CBText(text = "CBRowWeight")
            }

            CBColumnWeight()

        }
    }
}