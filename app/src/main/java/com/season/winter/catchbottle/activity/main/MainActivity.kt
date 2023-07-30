package com.season.winter.catchbottle.activity.main

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.main_navigation_contents.viewmodels.MainNavigationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainNavigationViewModel by viewModels()

    override fun ActivityMainBinding.initView() {
        repeatOnLifecycle(viewModel.onLogoutListener) {
            if (it) {
                cbStartActivity(LoginActivity::class.java, true)
            }
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottomNavigation.setupWithNavController(navController)
//        bottomNavigation.setOnItemSelectedListener { item ->
//            Log.e("TAG", "initView: item.title: ${item.title.toString()}", )
//            when (item.itemId) {
//                NavR.id.home_fragment ->
//                    Log.e("TAG", "initView: home_fragment", )
//
//                NavR.id.map_fragment->
//                    Log.e("TAG", "initView: map_fragment", )
//
//                NavR.id.wish_list_fragment->
//                    Log.e("TAG", "initView: wish_list_fragment", )
//
//                NavR.id.more_fragment->
//                    Log.e("TAG", "initView: more_fragment", )
//            }
//            true
//        }
    }

}