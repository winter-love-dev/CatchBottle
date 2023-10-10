package com.season.winter.main_navigation_contents.fragments.navigation

import androidx.fragment.app.activityViewModels
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentMoreBinding
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

class MoreFragment: BaseFragment<FragmentMoreBinding>(R.layout.fragment_more) {

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun FragmentMoreBinding.initView() {
//        activityViewModel.printCount()
        logoutButton.setOnClickListener {
            activityViewModel.onLogout()
        }

        viewLifecycleOwner.repeatOnLifecycle(activityViewModel.userName) {
            binding.nameTextView.text = "hello, $it!"
        }
    }
}