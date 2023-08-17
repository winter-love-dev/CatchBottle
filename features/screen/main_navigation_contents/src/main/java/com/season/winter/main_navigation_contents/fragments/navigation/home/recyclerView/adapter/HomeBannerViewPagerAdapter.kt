package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder.BannerDetailViewHolder
import com.season.winter.ui.model.fragment.home.BannerData

class HomeBannerViewPagerAdapter(
    private var bannerItems: List<BannerData>
): RecyclerView.Adapter<BannerDetailViewHolder>() {

    private var isAnnounce = false
    var announceBind: ((bannerItems: List<BannerData>) -> Unit)? = null

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerDetailViewHolder {
        return BannerDetailViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BannerDetailViewHolder, position: Int) {
        if (bannerItems.isEmpty()) return
        holder.bind(bannerItems[position % bannerItems.size])
        if (isAnnounce.not()) {
            announceBind?.invoke(bannerItems)
            isAnnounce = true
        }
    }

}