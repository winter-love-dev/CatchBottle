package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.main_navigation_contents.databinding.ItemBannerDetailBinding
import com.season.winter.ui.model.fragment.home.BannerData

class BannerDetailViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemBannerDetailBinding =
        ItemBannerDetailBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    fun bind(bannerItems: BannerData) {
//        binding.root.layoutParams = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
        binding.bannerData = bannerItems
//        binding.ivThumb.setImageFromUrlWrapHeight(bannerItems.imageUrl)
    }
}