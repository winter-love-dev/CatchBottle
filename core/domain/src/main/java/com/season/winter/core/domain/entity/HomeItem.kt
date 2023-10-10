package com.season.winter.core.domain.entity

import com.season.winter.liquor.filter.LiquorFilterOption
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.ui.model.fragment.home.BannerData

enum class HomeItemType {
    SearchBar,
    Banner,
    ShortcutMenu,
    LiquorGrouping,
    Footer,
    ;
}

//val liquorInfoDummyGenerator = LiquorInfoDummyGenerator()
//val liquorListAll = liquorInfoDummyGenerator.getLiquorListAll()

fun setLiquorItems(
    type: HomeItemType,
    liquorGroupingOption: LiquorFilterOption?
): List<LiquorInfo> {
    return if(type == HomeItemType.LiquorGrouping)
        liquorGroupingOption?.search() ?: emptyList()
    else
        emptyList()
}


data class HomeItem(
    val type: HomeItemType,
    val title: String? = null,
    val subTitle: String? = null,
    val liquorGroupingOption: LiquorFilterOption? = null,
    var bannerItems: List<BannerData>? = null,
    val liquorItems: List<LiquorInfo> = setLiquorItems(type, liquorGroupingOption),
)