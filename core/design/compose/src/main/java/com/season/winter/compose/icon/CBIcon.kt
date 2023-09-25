package com.season.winter.compose.icon

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import com.season.winter.designsystem.size.CBSize

@Composable
fun CBIcon(
    painter: Painter,
    size: CBSize = CBSize.L,
    width: Dp? = null,
    height: Dp? = null,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    tint: Color = LocalContentColor.current
) {

    Icon(
        painter,
        contentDescription = contentDescription,
        modifier = modifier
            .width(width ?: size.dp)
            .height(height ?: size.dp)
        ,
        tint = tint
    )
}