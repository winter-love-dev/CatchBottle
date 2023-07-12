package com.season.winter.designsystem.button

import com.season.winter.designsystem.color.CBColor

enum class CBButton {
    First, // 브랜드 컬러
    Second, // 짙은 그레이 컬러
    Third, // 옅은 그레이 컬러
    Ghost, // 배경이 안 보이는 버튼
    Negative, // 거부 버튼
    ;

    val enableBackgroundColor: Int get() = when(this) {
        First -> CBColor.BrandFirst.value
        Second -> CBColor.ButtonSecondEnable.value
        Third -> CBColor.ButtonThirdEnable.value
        Ghost -> CBColor.Transparent.value
        Negative -> CBColor.ButtonNegativeEnable.value
    }

    val disableBackgroundColor: Int get() = when(this) {
        First -> CBColor.ButtonDisable.value
        Second -> CBColor.ButtonDisable.value
        Third -> CBColor.ButtonDisable.value
        Ghost -> CBColor.ButtonDisable.value
        Negative -> CBColor.ButtonDisable.value
    }

    val enableTextColor: Int get() = when(this) {
        First -> CBColor.ButtonDisable.value
        Second -> CBColor.ButtonDisable.value
        Third -> CBColor.ButtonDisable.value
        Ghost -> CBColor.ButtonDisable.value
        Negative -> CBColor.ButtonDisable.value
    }

    val disableTextColor: Int get() = when(this) {
        First -> CBColor.ButtonTextDisable.value
        Second -> CBColor.ButtonTextDisable.value
        Third -> CBColor.ButtonTextDisable.value
        Ghost -> CBColor.ButtonTextDisable.value
        Negative -> CBColor.ButtonTextDisable.value
    }
}