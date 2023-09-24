package com.season.winter.designsystem.color.base

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorLong
import com.season.winter.designsystem.R

enum class Palette {
    BrandFirst,
    BrandLight,
    RedLight1,
    RedLight2,
    RedLight3,
    Red1,
    Red2,
    Red3,
    BlueLight1,
    BlueLight2,
    Blue1,
    Blue2,
    Gray1,
    Gray2,
    Gray3,
    Gray4,
    Gray5,
    Black,
    White,
    Transparent,
    ;

    val composeColor: Color get() = when(this) {
        BrandFirst -> Color(0XFF71663B)
        BrandLight -> Color(0XFFEBE9E3)
        RedLight1 -> Color(0XFFFFF5F5)
        RedLight2 -> Color(0XFFFFE0E0)
        RedLight3 -> Color(0XFFFFCCCC)
        Red1 -> Color(0XFFFF3333)
        Red2 -> Color(0XFFF53131)
        Red3 -> Color(0XFFEB2F2F)
        BlueLight1 -> Color(0XFFE0F1FF)
        BlueLight2 -> Color(0XFFCCE8FF)
        Blue1 -> Color(0XFF038CFF)
        Blue2 -> Color(0XFF0386F5)
        Gray1 -> Color(0XFFF5F5F5)
        Gray2 -> Color(0XFFE0E0E0)
        Gray3 -> Color(0XFFD6D6D6)
        Gray4 -> Color(0XFFA3A3A3)
        Gray5 -> Color(0XFF1F1F1F)
        Black -> Gray5.composeColor
        White -> Color(0XFFFFFFFF)
        Transparent -> Color(0x3FFFFFF)
    }

    val value: Int get() = when(this) {
        BrandFirst -> R.color.brand_first
        BrandLight -> R.color.brand_light
        RedLight1 -> R.color.red_light_1
        RedLight2 -> R.color.red_light_2
        RedLight3 -> R.color.red_light_3
        Red1 -> R.color.red_1
        Red2 -> R.color.red_2
        Red3 -> R.color.red_3
        BlueLight1 -> R.color.blue_light_1
        BlueLight2 -> R.color.blue_light_2
        Blue1 -> R.color.blue_1
        Blue2 -> R.color.blue_2
        Gray1 -> R.color.gray_1
        Gray2 -> R.color.gray_2
        Gray3 -> R.color.gray_3
        Gray4 -> R.color.gray_4
        Gray5 -> R.color.gray_5
        Black -> Gray5.value
        White -> R.color.white
        Transparent -> R.color.transparent
    }
}