package com.season.winter.ui.fragment.home

import com.season.winter.liquor.liquorInfo.LiquorInfo

data class LiquorGroupingItem(
    val title: Int,
    val subTitle: Int,
    val groupingTarget: List<GroupingBy>,
    val items: List<LiquorInfo>
)