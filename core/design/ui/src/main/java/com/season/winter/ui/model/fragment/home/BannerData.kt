package com.season.winter.ui.model.fragment.home

import com.season.winter.liquor.content.FeatureData

enum class BannerPageLinkType(
    val identify: Int
) {
    Web(0),
    App(1),
}

data class BannerData(
    val imageFileName: String,
    var imageUrls: String? = null,
    var webPageUrl: String? = null,
    var pageType: BannerPageLinkType? = null,
    var feature: FeatureData? = null,
)