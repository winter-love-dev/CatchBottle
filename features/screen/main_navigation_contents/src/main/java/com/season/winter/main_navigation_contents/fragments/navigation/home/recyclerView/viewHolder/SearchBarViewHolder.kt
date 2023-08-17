package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.main_navigation_contents.databinding.ItemLiquorGroupingBinding
import com.season.winter.main_navigation_contents.ui.recyclerView.adapter.MiniLiquorAdapter
import com.season.winter.liquor.dummy.model.HomeItem
import com.season.winter.liquor.dummy.model.HomeItemType
import com.season.winter.main_navigation_contents.databinding.ItemEmptyBinding
import com.season.winter.main_navigation_contents.databinding.ItemSearchBarBinding

class SearchBarViewHolder(
    val parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemSearchBarBinding =
        ItemSearchBarBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    var onClick: (() -> Unit)? = null

    init {
        binding.viewHolder = this
//        binding.setVariable(binding.viewHolder.id, this)
    }

    fun onClick() {
        onClick?.invoke()
    }
}