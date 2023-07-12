package com.season.winter.designsystem.color.base

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