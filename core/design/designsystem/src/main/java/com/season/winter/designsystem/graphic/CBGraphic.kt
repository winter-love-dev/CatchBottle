package com.season.winter.designsystem.graphic

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.season.winter.core_design_resource.R

enum class CBGraphic(
//    val painter: @Composable Painter
) {
    LogoFull(/*painterResource(R.drawable.logo_full)*/),
    LogoFullWhite,
    LogoIcon,
    LogoIconSmall,
    LogoIconWhite,
    LogoText,
    LogoTextWhite,
    ;

    val painter: Painter @Composable get() = when(this) {
        LogoFull -> painterResource(R.drawable.logo_full)
        LogoFullWhite -> painterResource(R.drawable.logo_full_white)
        LogoIcon -> painterResource(R.drawable.logo_icon)
        LogoIconSmall -> painterResource(R.drawable.logo_icon_small)
        LogoIconWhite -> painterResource(R.drawable.logo_icon_white)
        LogoText -> painterResource(R.drawable.logo_text)
        LogoTextWhite -> painterResource(R.drawable.logo_text_white)
    }
}
