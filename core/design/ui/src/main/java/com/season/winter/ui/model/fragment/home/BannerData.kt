package com.season.winter.ui.model.fragment.home

import com.season.winter.liquor.content.FeatureData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class BannerPageLinkType(
    @SerialName("pageType") val identify: Int
) {
    @SerialName("0") Web(0),
    @SerialName("1") InApp(1),
}

@Serializable
data class BannerData(
    val imageFileName: String,
    var imageUrls: String? = null,
    var webPageUrl: String? = null,
    var pageType: BannerPageLinkType? = null,
    var feature: FeatureData? = null,
)