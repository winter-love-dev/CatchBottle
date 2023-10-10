package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.core.domain.entity.HomeItem
import com.season.winter.main_navigation_contents.databinding.ItemLiquorGroupingBinding
import com.season.winter.main_navigation_contents.ui.recyclerView.adapter.MiniLiquorAdapter

class LiquorViewHolder(
    layoutRes: Int,
    val parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemLiquorGroupingBinding =
        ItemLiquorGroupingBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    var onClickMore: ((position: Int) -> Unit)? = null
    private val miniLiquorAdapter = MiniLiquorAdapter()

    init {
        binding.run {
            viewHolder = this@LiquorViewHolder
            miniAdapter = miniLiquorAdapter
            layoutManager = LinearLayoutManager(
                parent.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }

    fun bind(homeItem: HomeItem) {
        binding.homeItem = homeItem
        miniLiquorAdapter.initData(homeItem.liquorItems)
    }

    fun onClickMore() {
        onClickMore?.invoke(adapterPosition)
    }
}