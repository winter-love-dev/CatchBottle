package com.season.winter.main_navigation_contents.ui.recyclerView.adapter

import androidx.recyclerview.widget.DiffUtil
import com.season.winter.liquor.liquorInfo.LiquorInfo

class LiquorDiffCallback: DiffUtil.ItemCallback<LiquorInfo>() {

    override fun areItemsTheSame(oldItem: LiquorInfo, newItem: LiquorInfo): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: LiquorInfo, newItem: LiquorInfo): Boolean =
        oldItem.nameKo == newItem.nameKo
}