package com.season.winter.main_navigation_contents.fragments.navigation

import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentWishListBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment

class WishListFragment: BaseNavigationFragment<FragmentWishListBinding>(R.layout.fragment_wish_list) {

    override fun FragmentWishListBinding.initAfterView() {
        activityViewModel.printCount()
    }
}