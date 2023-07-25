package com.season.winter.main_navigation_contents.ui.recyclerView.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.main_navigation_contents.ui.recyclerView.viewHolder.MiniLiquorViewHolder

class MiniLiquorAdapter: ListAdapter<LiquorInfo, MiniLiquorViewHolder>(LiquorDiffCallback()) {

    override fun getItemCount(): Int = currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiniLiquorViewHolder {
        return MiniLiquorViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MiniLiquorViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    fun initData(list: List<LiquorInfo>) {
        submitList(list.toMutableList())
    }
}