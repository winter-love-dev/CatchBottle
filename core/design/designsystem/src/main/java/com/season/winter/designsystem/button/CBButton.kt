package com.season.winter.designsystem.button

import androidx.compose.ui.graphics.Color
import com.season.winter.designsystem.color.CBColor

enum class CBButtonStyleCompose(
    val enableBackgroundColor: Color,
    val disableBackgroundColor: Color,
    val enableTextColor: Color,
    val disableTextColor: Color,
) {
    First( // 브랜드 컬러
        enableBackgroundColor = CBColor.BrandFirst.composeValue,
        disableBackgroundColor = CBColor.ButtonDisable.composeValue,
        enableTextColor = CBColor.ButtonDisable.composeValue,
        disableTextColor = CBColor.ButtonTextDisable.composeValue,
    ),
    Second( // 짙은 그레이 컬러
        enableBackgroundColor = CBColor.ButtonSecondEnable.composeValue,
        disableBackgroundColor = CBColor.ButtonDisable.composeValue,
        enableTextColor = CBColor.ButtonDisable.composeValue,
        disableTextColor = CBColor.ButtonTextDisable.composeValue,
    ),
    Third(// 옅은 그레이 컬러
        enableBackgroundColor = CBColor.ButtonThirdEnable.composeValue,
        disableBackgroundColor = CBColor.ButtonDisable.composeValue,
        enableTextColor = CBColor.ButtonDisable.composeValue,
        disableTextColor = CBColor.ButtonTextDisable.composeValue,
    ),
    Ghost( // 배경이 안 보이는 버튼
        enableBackgroundColor = CBColor.Transparent.composeValue,
        disableBackgroundColor = CBColor.ButtonDisable.composeValue,
        enableTextColor = CBColor.ButtonTextEnable.composeValue,
        disableTextColor = CBColor.ButtonTextDisable.composeValue,
    ),
    Negative( // 거부 버튼
        enableBackgroundColor = CBColor.ButtonNegativeEnable.composeValue,
        disableBackgroundColor = CBColor.ButtonDisable.composeValue,
        enableTextColor = CBColor.ButtonTextNegative.composeValue,
        disableTextColor = CBColor.ButtonTextDisable.composeValue,
    ),
    ;
}

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