package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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