package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.season.winter.liquor.dummy.filter.LiquorFilter
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder.LiquorViewHolder
import com.season.winter.liquor.dummy.model.HomeItem
import com.season.winter.liquor.dummy.model.HomeItemType
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder.BannerSectionViewHolder
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder.EmptyViewHolder

class HomeRecyclerViewAdapter: ListAdapter<HomeItem, ViewHolder>(HomeDiffCallback()) {

    private var lifecycleOwner: LifecycleOwner? = null

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int = currentList[position].type.res

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType) {
            HomeItemType.Banner.res -> BannerSectionViewHolder(parent)
            HomeItemType.LiquorGrouping.res -> LiquorViewHolder(viewType, parent)
            else -> EmptyViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder) {
            is BannerSectionViewHolder -> holder.bind(currentList[position].bannerItems, lifecycleOwner)
            is LiquorViewHolder -> holder.bind(currentList[position])
            is EmptyViewHolder -> holder.bind()
        }
    }

    fun initData(list: List<HomeItem>) {
        submitList(list.toMutableList())
    }

    fun setLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
    }

    fun onClickItem(position: Int) {
        Log.e(TAG, "onClickItem: $position", )
    }

    override fun onCurrentListChanged(
        previousList: MutableList<HomeItem>,
        currentList: MutableList<HomeItem>
    ) {
        super.onCurrentListChanged(previousList, currentList)
    }

    companion object {

        val TAG: String = this::class.java.simpleName.toString()
    }
}