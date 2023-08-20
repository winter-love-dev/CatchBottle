package com.season.winter.main_navigation_contents.fragments.navigation.home

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.BR
import com.season.winter.main_navigation_contents.R
import com.season.winter.main_navigation_contents.databinding.FragmentHomeBinding
import com.season.winter.main_navigation_contents.fragments.base.BaseNavigationFragment
import com.season.winter.main_navigation_contents.fragments.navigation.home.recyclerView.adapter.HomeRecyclerViewAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment: BaseNavigationFragment<FragmentHomeBinding>(R.layout.fragment_home) {


    override fun FragmentHomeBinding.initAfterView() {
        adapter = HomeRecyclerViewAdapter().apply {
            setLifecycleOwner(this@HomeFragment)
            repeatOnLifecycle(onClickSearchListener) {
                activityViewModel.onClickSearch()
            }
        }
        layoutManager = LinearLayoutManager(requireContext())
        repeatOnLifecycle(activityViewModel.mainListFlow) { homeData ->
            adapter?.initData(homeData)
        }

        // 타이밍 이슈 의심됨.
        // 홈 탭 이탈하고 돌아오면 홈화면 렌더링 되지 않음.
        // 리사이클러뷰 초기화 타이밍보다 데이터 넘기는 속도가 빨라서 그런것 같은데.
        // 뷰 초기화 타이밍을 어떻게 알 수 있을까
        lifecycleScope.launch {
            delay(10L)
            activityViewModel.getMainList()
        }
    }

    companion object {

        private const val TAG = "HomeFragment"
    }
}