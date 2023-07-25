package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.main_navigation_contents.databinding.ItemLiquorGroupingBinding
import com.season.winter.main_navigation_contents.ui.recyclerView.adapter.MiniLiquorAdapter
import com.season.winter.ui.fragment.home.HomeItem
import com.season.winter.ui.fragment.home.HomeItemType

class HomeViewHolder(
    layoutRes: Int,
    val parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemLiquorGroupingBinding =
        ItemLiquorGroupingBinding.inflate(layoutInflater, parent, false),
//    val binding: ItemLiquorGroupingBinding =
//        DataBindingUtil.inflate(layoutInflater, layoutRes, parent, false)
): RecyclerView.ViewHolder(binding.root) {

    var onClickMore: ((position: Int) -> Unit)? = null
    private val miniLiquorAdapter = MiniLiquorAdapter()

    init {
        binding.run {
            viewHolder = this@HomeViewHolder
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
        if (homeItem.type == HomeItemType.LiquorGrouping)
            miniLiquorAdapter.initData(homeItem.liquorItems)
    }

    fun onClickMore() {
        onClickMore?.invoke(adapterPosition)
    }
}