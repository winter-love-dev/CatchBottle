package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import androidx.recyclerview.widget.DiffUtil
import com.season.winter.ui.model.fragment.home.HomeItem

class HomeDiffCallback: DiffUtil.ItemCallback<HomeItem>() {

    override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean =
        oldItem.type == newItem.type
}