package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder.HomeViewHolder
import com.season.winter.ui.model.fragment.home.HomeItem
import com.season.winter.ui.textView.CBTextView

class HomeRecyclerViewAdapter: ListAdapter<HomeItem, HomeViewHolder>(HomeDiffCallback()) {

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int = currentList[position].type.res

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(viewType, parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(currentList[position])

        holder.onClickMore = {
            Log.e(TAG, "onClickItem: $it", )
        }
    }

    fun initData(list: List<HomeItem>) {
        submitList(list.toMutableList())
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