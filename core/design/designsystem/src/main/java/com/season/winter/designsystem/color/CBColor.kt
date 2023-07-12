package com.season.winter.designsystem.color

import com.season.winter.designsystem.color.base.Palette

enum class CBColor {
    White,
    Black,
    Transparent,
    BrandFirst,
    BrandLight,

    TextFist, // 본문 텍스트 컬러
    TextSecond, // 서브 텍스트 컬러
    TextDisabled, // 비활성화 텍스트 컬러
    TextNegative, // 에러, 경고성 피드백 텍스트 컬러
    TextPositive, // 긍정, 성공 피드백 텍스트 컬러

    InputBoxEnable,
    InputBoxDisable,
    InputBoxError,

    InputBoxBorderEnable,
    InputBoxBorderFocus,
    InputBoxBorderError,
    InputBoxBorderDisable,

    InputPlaceHolder,
    InputTyping,

    ListTitleEnable,
    ListTitleDisable,

    ListLabelEnable,
    ListLabelDisable,

    ListDescriptionEnable,
    ListDescriptionDisable,

    Divider,

    ButtonSecondEnable,
    ButtonThirdEnable,

    ButtonNegativeEnable,
    ButtonDisable,

    ButtonTextEnable,
    ButtonTextInverseEnable,
    ButtonTextDisable,

    ButtonTextNegative,
    ButtonTextPositive,
    ;


    val value: Int get() = when(this) {

        White -> Palette.White.value
        Black -> Palette.Black.value
        Transparent -> Palette.Transparent.value
        BrandFirst -> Palette.BrandFirst.value
        BrandLight -> Palette.BrandLight.value

        TextFist -> Palette.Gray5.value
        TextSecond -> Palette.Gray4.value
        TextDisabled -> Palette.Gray3.value
        TextNegative -> Palette.Red1.value
        TextPositive -> Palette.Blue1.value

        InputBoxEnable -> Palette.Gray2.value
        InputBoxDisable -> Palette.Gray3.value
        InputBoxError -> Palette.RedLight1.value

        InputBoxBorderEnable -> Palette.Gray4.value
        InputBoxBorderFocus -> Palette.Gray5.value
        InputBoxBorderError -> Palette.Red1.value
        InputBoxBorderDisable -> Palette.Gray2.value

        InputPlaceHolder -> Palette.Gray2.value
        InputTyping -> Palette.Gray5.value

        ListTitleEnable -> Palette.Gray5.value
        ListTitleDisable -> Palette.Gray3.value

        ListLabelEnable ->Palette.Gray4.value
        ListLabelDisable -> Palette.Gray2.value

        ListDescriptionEnable -> Palette.Gray4.value
        ListDescriptionDisable -> Palette.Gray2.value

        Divider -> Palette.Gray1.value

        ButtonSecondEnable      -> Palette.Gray5.value
        ButtonThirdEnable       -> Palette.Gray4.value
        ButtonNegativeEnable    -> Palette.RedLight2.value
        ButtonDisable           -> Palette.Gray3.value

        ButtonTextEnable        -> Palette.Gray4.value
        ButtonTextInverseEnable -> Palette.Gray1.value
        ButtonTextDisable       -> Palette.Gray4.value

        ButtonTextNegative      -> Palette.Red2.value
        ButtonTextPositive      -> Palette.Blue2.value
    }

}