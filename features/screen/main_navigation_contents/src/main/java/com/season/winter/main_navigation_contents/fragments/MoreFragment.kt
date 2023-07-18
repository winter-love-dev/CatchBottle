package com.season.winter.main_navigation_contents.fragments

import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentMoreBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment

class MoreFragment: BaseNavigationFragment<FragmentMoreBinding>(R.layout.fragment_more) {

    override fun FragmentMoreBinding.initAfterView() {
        activityViewModel.printCount()
    }
}