package com.season.winter.main_navigation_contents.ui.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.liquor.liquorInfo.LiquorInfo
import com.season.winter.main_navigation_contents.databinding.ItemLiquorMiniBinding
import com.season.winter.storage.extenstion.glide.preloadImageFromFireStoreFileName

class MiniLiquorViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemLiquorMiniBinding =
        ItemLiquorMiniBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    var onClickMore: ((position: Int) -> Unit)? = null

    init {
        binding.root.setOnClickListener {
            onClickMore?.invoke(adapterPosition)
        }
    }

    fun bind(liquorInfo: LiquorInfo) {
        binding.liquorInfo = liquorInfo
    }

    // image preload
//    fun bind(liquorInfoList: List<LiquorInfo>) {
//
//        binding.liquorInfo = liquorInfoList[adapterPosition]
//
//        if (adapterPosition <= liquorInfoList.size) {
//            val endPosition = if (adapterPosition + 6 > liquorInfoList.size) {
//                liquorInfoList.size
//            } else {
//                adapterPosition + 6
//            }
//            liquorInfoList.subList(adapterPosition, endPosition).map { it.thumbnailFileName }.forEach {
//                binding.ivThumb.preloadImageFromFireStoreFileName(it)
//            }
//        }
//    }
}