package com.season.winter.ui.model.fragment.home

import com.season.winter.liquor.dummy.LiquorInfoDummyGenerator
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.filter.LiquorFilterOption

enum class HomeItemType {
    SearchBar,
    Banner,
    ShortcutMenu,
    LiquorGrouping,
    Footer,
    ;
}

val liquorInfoDummyGenerator = com.season.winter.liquor.dummy.LiquorInfoDummyGenerator()
val liquorListAll = liquorInfoDummyGenerator.getLiquorListAll()

fun setLiquorItems(
    type: HomeItemType,
    liquorGroupingOption: com.season.winter.liquor.filter.LiquorFilterOption?
): List<LiquorInfo> {
    return if(type == HomeItemType.LiquorGrouping)
        liquorGroupingOption?.search() ?: liquorListAll
    else
        emptyList()
}

data class HomeItem(
    val type: HomeItemType,
    val title: String? = null,
    val subTitle: String? = null,
    val liquorGroupingOption: com.season.winter.liquor.filter.LiquorFilterOption? = null,
    val liquorItems: List<LiquorInfo> = setLiquorItems(type, liquorGroupingOption)
)