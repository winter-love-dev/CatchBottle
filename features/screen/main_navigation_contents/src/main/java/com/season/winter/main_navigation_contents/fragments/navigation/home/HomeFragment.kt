package com.season.winter.main_navigation_contents.fragments.navigation.home

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentHomeBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter.HomeRecyclerViewAdapter

class HomeFragment: BaseNavigationFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun FragmentHomeBinding.initAfterView() {
        adapter = HomeRecyclerViewAdapter()
        layoutManager = LinearLayoutManager(requireContext())
        repeatOnLifecycle(activityViewModel.mainListFlow) { homeData ->
            Log.e("TAG", "initAfterView: $homeData", )
            adapter?.initData(homeData)
        }
    }

    companion object {

        private const val TAG = "HomeFragment"
    }
}