package com.season.winter.compose.spacing

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.season.winter.designsystem.spacing.CBSpacing

@Composable
@SuppressLint("ComposableModifierFactory")
fun Modifier.cbPadding(
    spacing: CBSpacing = CBSpacing.M,
    start: Boolean = false,
    top: Boolean = false,
    end: Boolean = false,
    bottom: Boolean = false,
): Modifier {

    if (
        start.not() &&
        top.not() &&
        end.not() &&
        bottom.not()
    ) return this.padding(spacing.dp)

    return this.padding(
        if (start) spacing.dp else 0.dp,
        if (top) spacing.dp else 0.dp,
        if (end) spacing.dp else 0.dp,
        if (bottom) spacing.dp else 0.dp
    )
}

@Composable
@SuppressLint("ComposableModifierFactory")
fun Modifier.cbPadding(
    spacing: CBSpacing = CBSpacing.M,
    vertical: Boolean,
    horizontal: Boolean,
) = this.padding(
    vertical = if (vertical) spacing.dp else 0.dp,
    horizontal = if (horizontal) spacing.dp else 0.dp
)
