package com.season.winter.main_navigation_contents.fragments.navigation

import androidx.fragment.app.activityViewModels
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentMapBinding
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

class MapFragment: BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun FragmentMapBinding.initView() {
//        activityViewModel.printCount()
    }
}