package com.season.winter.designsystem.typography.base

import com.season.winter.core_design_resource.R

enum class FontFamily(val resource: Int) {
    NotosansRegular(R.font.notosanscjkkr_r),
    NotosansMedium(R.font.notosanscjkkr_m),
    NotosansBold(R.font.notosanscjkkr_b),
    PretendardRegular(R.font.pretendard_r),
    PretendardMedium(R.font.pretendard_m),
    PretendardBold(R.font.pretendard_b),
    ;

    companion object {
        val RegularResource = PretendardRegular.resource
        val MediumResource  = PretendardMedium.resource
        val BoldResource    = PretendardBold.resource
    }
}
