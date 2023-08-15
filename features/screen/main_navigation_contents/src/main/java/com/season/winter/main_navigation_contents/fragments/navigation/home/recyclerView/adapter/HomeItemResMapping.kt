package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import com.season.winter.main_navigation_contents.R
import com.season.winter.liquor.dummy.model.HomeItemType

val HomeItemType.res: Int get() = when (this) {
    HomeItemType.SearchBar -> R.layout.item_search_ber
    HomeItemType.Banner -> R.layout.item_banner
    HomeItemType.ShortcutMenu -> R.layout.item_short_cut_menu
    HomeItemType.LiquorGrouping -> R.layout.item_liquor_grouping
    HomeItemType.Footer -> R.layout.item_footer
}