package com.season.winter.designsystem.typography.base

import com.season.winter.core_design_resource.R

enum class FontFamily {
    NotosansRegular,
    NotosansMedium,
    NotosansBold,
    PretendardRegular,
    PretendardMedium,
    PretendardBold,
    ;

    val resource: Int get() =
        when(this) {
            NotosansRegular -> R.font.notosanscjkkr_r
            NotosansMedium  -> R.font.notosanscjkkr_m
            NotosansBold    -> R.font.notosanscjkkr_b
            PretendardRegular -> R.font.pretendard_r
            PretendardMedium  -> R.font.pretendard_m
            PretendardBold    -> R.font.pretendard_b
        }

    companion object {
        val RegularResource = NotosansRegular.resource
        val MediumResource  = NotosansMedium.resource
        val BoldResource    = NotosansBold.resource
    }
}
