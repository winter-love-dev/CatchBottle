package com.season.winter.main_navigation_contents.fragments.navigation

import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentHomeBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment

class HomeFragment: BaseNavigationFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun FragmentHomeBinding.initAfterView() {
        activityViewModel.printCount()
        countBtn.setOnClickListener {
            activityViewModel.countUp()
            activityViewModel.printCount()
        }

        viewLifecycleOwner.repeatOnLifecycle(activityViewModel.userName) {
            binding.nameTextView.text = "hello, $it!"
        }
    }
}