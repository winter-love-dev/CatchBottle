package com.season.winter.main_navigation_contents.fragments.navigation.home

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.common.fragment.BaseFragment
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentHomeBinding
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter.HomeRecyclerViewAdapter
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel
import kotlinx.coroutines.launch

class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val activityViewModel: MainNavigationViewModel by activityViewModels()

    override fun FragmentHomeBinding.initView() {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = HomeRecyclerViewAdapter().apply {
            setLifecycleOwner(this@HomeFragment)
            repeatOnLifecycle(
                onClickSearchListener,
                repeatWhen = Lifecycle.State.CREATED,
            ) { onClickSearch ->
                if (onClickSearch)
                    activityViewModel.onClickSearch()
            }
        }
        repeatOnLifecycle(
            activityViewModel.homeScreenDataFlow,
            repeatWhen = Lifecycle.State.CREATED,
        ) { homeData ->
            adapter?.initData(homeData)
        }
        lifecycleScope.launch {
            activityViewModel.getMainList()
        }
    }

    companion object {

        private const val TAG = "HomeFragment"
    }
}