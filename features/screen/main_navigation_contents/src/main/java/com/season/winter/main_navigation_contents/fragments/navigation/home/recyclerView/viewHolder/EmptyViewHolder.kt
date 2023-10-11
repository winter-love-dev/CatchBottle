package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.main_navigation_contents.databinding.ItemEmptyBinding

class EmptyViewHolder(
    val parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemEmptyBinding =
        ItemEmptyBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    fun bind() {
    }
}