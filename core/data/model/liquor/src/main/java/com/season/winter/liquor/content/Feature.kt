package com.season.winter.liquor.content

import android.graphics.Typeface
import com.season.winter.designsystem.typography.CBTypography

enum class FeatureType(
    number: Int,
    colorRes: Int? = null,
    fontFamily: CBTypography = CBTypography.BodyM
){
    Text(0),
    ImageUrl(1),
    YouTubeVideoUrl(2),
}

data class FeatureData(
    val type: FeatureType,
    val source: String
)