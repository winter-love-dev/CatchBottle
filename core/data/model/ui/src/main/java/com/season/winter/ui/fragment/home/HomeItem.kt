package com.season.winter.ui.fragment.home

import com.season.winter.liquor.dummy.LiquorInfoDummyGenerator
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.liquor.liquorInfo.filter.LiquorFilterOption

enum class HomeItemType {
    SearchBar,
    Banner,
    ShortcutMenu,
    LiquorGrouping,
    Footer,
    ;
}

val liquorInfoDummyGenerator = LiquorInfoDummyGenerator()
val liquorListAll = liquorInfoDummyGenerator.getLiquorListAll()

fun setLiquorItems(
    type: HomeItemType,
    liquorGroupingOption: LiquorFilterOption?
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
    val liquorGroupingOption: LiquorFilterOption? = null,
    val liquorItems: List<LiquorInfo> = setLiquorItems(type, liquorGroupingOption)
)