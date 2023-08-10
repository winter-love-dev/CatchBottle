package com.season.winter.liquor.content

import com.season.winter.designsystem.color.CBColor
import com.season.winter.designsystem.typography.CBTypography

enum class FeatureType(
    val identify: Int,
){
    Text(0),
    ImageUrl(1),
    YouTubeVideoUrl(2),
}

data class FeatureData(
    val type: FeatureType,
    val colorRes: Int = CBColor.Black.value, // textColor
    val fontFamily: CBTypography = CBTypography.BodyM,
    val source: String, // text or url
    val clickActionUrl: String? = null, // 텍스트 or 이미지 클릭했을 때의 액션 지정
)