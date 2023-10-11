package com.season.winter.main_navigation_contents.fragments.navigation

import androidx.fragment.app.activityViewModels
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentWishListBinding
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

class WishListFragment: BaseFragment<FragmentWishListBinding>(R.layout.fragment_wish_list) {

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun FragmentWishListBinding.initView() {
//        activityViewModel.printCount()
    }
}