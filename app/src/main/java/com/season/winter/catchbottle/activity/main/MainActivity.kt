package com.season.winter.catchbottle.activity.main

import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.cbWhenStarted
import com.season.winter.main_navigation_contents.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun ActivityMainBinding.initView() {

        viewModel.onLogoutListener = {
            cbStartActivity(LoginActivity::class.java)
        }

        coroutine.launch {
            cbWhenStarted {
                viewModel.onCountFlow.collect { count ->
                    Log.e("TAG", "initView: received main activity: count: $count", )
                }
            }
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottomNavigation.setupWithNavController(navController)
    }

}