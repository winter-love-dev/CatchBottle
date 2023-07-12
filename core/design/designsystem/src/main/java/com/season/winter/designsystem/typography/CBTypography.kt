package com.season.winter.designsystem.typography

import com.season.winter.designsystem.typography.base.Size
import com.season.winter.designsystem.typography.base.Weight

enum class CBTypography {
    HeadL,
    HeadM,
    HeadS,
    HeadXs,

    BodyL,
    BodyM,
    BodyS,

    CaptionM,
    CaptionS,

    ButtonFirst,
    ButtonSecond,

    InputPlaceHolder,
    InputLabel,
    InputCaption,

    ListTitle,
    ListDescription,
    ListLabel,
    ;

    val weight: Int  get() = when(this) {
        HeadL    -> Weight._700.value
        HeadM    -> Weight._700.value
        HeadS    -> Weight._700.value
        HeadXs   -> Weight._600.value
        BodyL    -> Weight._500.value
        BodyM    -> Weight._500.value
        BodyS    -> Weight._500.value
        CaptionM -> Weight._500.value
        CaptionS -> Weight._500.value

        ButtonFirst -> BodyM.weight
        ButtonSecond -> BodyS.weight

        InputPlaceHolder -> BodyM.weight
        InputLabel -> CaptionM.weight
        InputCaption -> CaptionM.weight

        ListTitle -> BodyM.weight
        ListDescription -> CaptionM.weight
        ListLabel -> CaptionM.weight
    }

    val size: Int get() = when(this) {
        HeadL    -> Size.Xxl.value
        HeadM    -> Size.Xl.value
        HeadS    -> Size.L.value
        HeadXs   -> Size.M.value
        BodyL    -> Size.Xl.value
        BodyM    -> Size.M.value
        BodyS    -> Size.S.value
        CaptionM -> Size.S.value
        CaptionS -> Size.Xs.value

        ButtonFirst -> BodyM.size
        ButtonSecond -> BodyS.size

        InputPlaceHolder -> BodyM.size
        InputLabel -> CaptionM.size
        InputCaption -> CaptionM.size

        ListTitle -> BodyM.size
        ListDescription -> CaptionM.size
        ListLabel -> CaptionM.size
    }
}