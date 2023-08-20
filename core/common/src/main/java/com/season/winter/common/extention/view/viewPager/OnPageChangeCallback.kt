package com.season.winter.common.extention.view.viewPager

import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.onPageSelected(onChange: (position: Int) -> Unit) {
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            onChange(position)
        }
    })
}

fun ViewPager2.onPageScrollStateChanged(onChange: (state: Int) -> Unit) {
    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrollStateChanged(state: Int) {
            super.onPageScrollStateChanged(state)
            /* state:
            * ViewPager2.SCROLL_STATE_IDLE
            * ViewPager2.SCROLL_STATE_DRAGGING
            * ViewPager2.SCROLL_STATE_SETTLING
            */
            onChange(state)
        }
    })
}