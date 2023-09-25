package com.season.winter.designsystem.color

import androidx.compose.ui.graphics.Color
import com.season.winter.designsystem.color.base.Palette

enum class CBColor(
    val value: Int,
    val color: Color
) {
    White(Palette.White.value, Palette.White.composeColor),
    Black(Palette.Black.value, Palette.Black.composeColor),
    Transparent(Palette.Transparent.value, Palette.Transparent.composeColor),
    BrandFirst(Palette.BrandFirst.value, Palette.BrandFirst.composeColor),
    BrandLight(Palette.BrandLight.value, Palette.BrandLight.composeColor),
    TextFist(Palette.Gray5.value, Palette.Gray5.composeColor), // 본문 텍스트 컬러
    TextSecond(Palette.Gray4.value, Palette.Gray4.composeColor), // 서브 텍스트 컬러
    TextDisabled(Palette.Gray3.value, Palette.Gray3.composeColor), // 비활성화 텍스트 컬러
    TextNegative(Palette.Red1.value, Palette.Red1.composeColor), // 에러, 경고성 피드백 텍스트 컬러
    TextPositive(Palette.Blue1.value, Palette.Blue1.composeColor), // 긍정, 성공 피드백 텍스트 컬러
    InputBoxEnable(Palette.Gray2.value, Palette.Gray2.composeColor),
    InputBoxDisable(Palette.Gray3.value, Palette.Gray3.composeColor),
    InputBoxError(Palette.RedLight1.value, Palette.RedLight1.composeColor),
    InputBoxBorderEnable(Palette.Gray4.value, Palette.Gray4.composeColor),
    InputBoxBorderFocus(Palette.Gray5.value, Palette.Gray5.composeColor),
    InputBoxBorderError(Palette.Red1.value, Palette.Red1.composeColor),
    InputBoxBorderDisable(Palette.Gray2.value, Palette.Gray2.composeColor),
    InputPlaceHolder(Palette.Gray2.value, Palette.Gray2.composeColor),
    InputTyping(Palette.Gray5.value, Palette.Gray5.composeColor),
    ListTitleEnable(Palette.Gray5.value, Palette.Gray5.composeColor),
    ListTitleDisable(Palette.Gray3.value, Palette.Gray3.composeColor),
    ListLabelEnable(Palette.Gray4.value, Palette.Gray4.composeColor),
    ListLabelDisable(Palette.Gray2.value, Palette.Gray2.composeColor),
    ListDescriptionEnable(Palette.Gray4.value, Palette.Gray4.composeColor),
    ListDescriptionDisable(Palette.Gray2.value, Palette.Gray2.composeColor),
    Divider(Palette.Gray1.value, Palette.Gray1.composeColor),
    ButtonSecondEnable(Palette.Gray5.value, Palette.Gray5.composeColor),
    ButtonThirdEnable(Palette.Gray4.value, Palette.Gray4.composeColor),
    ButtonNegativeEnable(Palette.RedLight2.value, Palette.RedLight2.composeColor),
    ButtonDisable(Palette.Gray3.value, Palette.Gray3.composeColor),
    ButtonTextEnable(Palette.Gray4.value, Palette.Gray4.composeColor),
    ButtonTextInverseEnable(Palette.Gray1.value, Palette.Gray1.composeColor),
    ButtonTextDisable(Palette.Gray4.value, Palette.Gray4.composeColor),
    ButtonTextNegative(Palette.Red2.value, Palette.Red2.composeColor),
    ButtonTextPositive(Palette.Blue2.value, Palette.Blue2.composeColor),
    ;

}