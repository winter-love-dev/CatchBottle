package com.season.winter.main_navigation_contents.fragments.detail.more

import androidx.fragment.app.activityViewModels
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentUserInfoBinding
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

class UserInfoFragment: BaseFragment<FragmentUserInfoBinding>(R.layout.fragment_user_info) {

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun FragmentUserInfoBinding.initView() {

    }
}