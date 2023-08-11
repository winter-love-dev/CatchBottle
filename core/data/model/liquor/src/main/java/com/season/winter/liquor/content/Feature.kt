package com.season.winter.liquor.content

import com.season.winter.designsystem.color.CBColor
import com.season.winter.designsystem.typography.CBTypography
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class FeatureType(
    @SerialName("type") val identify: Int,
){
    @SerialName("0") Text(0),
    @SerialName("1") ImageUrl(1),
    @SerialName("2") YouTubeVideoUrl(2),
}

@Serializable
data class FeatureData(
    val type: FeatureType,
    val colorRes: Int = CBColor.Black.value, // textColor
    val fontFamily: CBTypography = CBTypography.BodyM,
    val source: String, // text or url
    val clickActionUrl: String? = null, // 텍스트 or 이미지 클릭했을 때의 액션 지정
)