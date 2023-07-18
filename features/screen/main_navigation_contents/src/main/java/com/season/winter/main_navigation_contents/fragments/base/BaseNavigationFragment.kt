package com.season.winter.main_navigation_contents.fragments.base

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.viewmodels.MainViewModel

abstract class BaseNavigationFragment<T: ViewDataBinding>(layoutResourceId: Int): BaseFragment<T>(layoutResourceId) {

    protected val activityViewModel: MainViewModel by activityViewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T =
                MainViewModel() as T
        }
    }

    override fun initStartView() {

    }

}