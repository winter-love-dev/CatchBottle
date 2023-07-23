package com.season.winter.model.content

enum class FeatureType(number: Int){
    Text(0),
    ImageUrl(1),
    YouTubeVideoUrl(2),
}

data class FeatureData(
    val type: FeatureType,
    val source: String
)