package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import androidx.recyclerview.widget.DiffUtil
import com.season.winter.liquor.dummy.model.HomeItem

class HomeDiffCallback: DiffUtil.ItemCallback<HomeItem>() {

    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean =
        oldItem.type == newItem.type
}