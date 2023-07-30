package com.season.winter.main_navigation_contents.fragments.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel

abstract class BaseNavigationFragment<T: ViewDataBinding>(layoutResourceId: Int): BaseFragment<T>(layoutResourceId) {

    protected val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun initStartView() {

    }

}