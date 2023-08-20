package com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.viewHolder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.SCROLL_STATE_DRAGGING
import androidx.viewpager2.widget.ViewPager2.SCROLL_STATE_IDLE
import com.season.winter.common.extention.coroutine.launchRepeatOnLifecycleStarted
import com.season.winter.common.extention.view.viewPager.onPageScrollStateChanged
import com.season.winter.common.extention.view.viewPager.onPageSelected
import com.season.winter.main_navigation_contents.databinding.ItemBannerSectionBinding
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter.HomeBannerViewPagerAdapter
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlin.math.ceil

class BannerSectionViewHolder(
    private val parent: ViewGroup,
    layoutInflater: LayoutInflater = LayoutInflater.from(parent.context),
    val binding: ItemBannerSectionBinding =
        ItemBannerSectionBinding.inflate(layoutInflater, parent, false),
): RecyclerView.ViewHolder(binding.root) {

    private var bannerPosition = 0
    private var isAlreadyBind = false

    @Volatile private var job: Job? = null

    fun bind(bannerItems: List<BannerData>?, lifecycleOwner: LifecycleOwner?) {

        if (isAlreadyBind) return
        isAlreadyBind = true

        val list: List<BannerData> = bannerItems ?: return

        binding.adapter = HomeBannerViewPagerAdapter(list).apply {

            announceBind = { list ->

                // list 의 중간 지점을 구한다
                val centerPosition = ceil(list.size.toDouble() / 2).toInt()

                // Int.MAX_VALUE 의 중간 지점에서 list의 첫 번 째 포지션을 맞춰준다.
                bannerPosition = ((Int.MAX_VALUE / 2 - centerPosition) - centerPosition) + 1
                binding.viewPager.setCurrentItem(bannerPosition, false)
            }
        }
        binding.viewPager.onPageSelected { position ->
            bannerPosition = position
            val currentPosition = (bannerPosition % list.size) + 1
            binding.page = "$currentPosition / ${list.size}"
        }
        binding.viewPager.onPageScrollStateChanged { state ->
            when (state) {
                SCROLL_STATE_IDLE ->
                    scrollJobCreate(lifecycleOwner)
                SCROLL_STATE_DRAGGING ->
                    cancelScrollJob()
            }
        }
        scrollJobCreate(lifecycleOwner)
    }

    private fun cancelScrollJob() {
        Log.e("TAG", "job cancel: ", )
        job?.cancel()
        job = null
    }

    private fun scrollJobCreate(lifecycleOwner: LifecycleOwner?) {
        cancelScrollJob()
        job ?: synchronized(this) {
            job ?: lifecycleOwner?.launchRepeatOnLifecycleStarted {
                delay(6000L)
                binding.viewPager.setCurrentItem(++bannerPosition, true)
            }.also { job = it }
        }
    }

}
