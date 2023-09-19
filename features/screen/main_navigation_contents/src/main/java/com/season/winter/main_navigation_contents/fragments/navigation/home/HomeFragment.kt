package com.season.winter.main_navigation_contents.fragments.navigation.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentHomeBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter.HomeRecyclerViewAdapter
import kotlinx.coroutines.launch

class HomeFragment: BaseNavigationFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun FragmentHomeBinding.initAfterView() {
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