package com.season.winter.catchbottle.activity.main

import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun ActivityMainBinding.initView() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottomNavigation.setupWithNavController(navController)



//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
//        val navController = navHostFragment.navController
//        bottomNavigation.setupWithNavController(navController)

//        NavigationUI.setupWithNavController(bottomNavigation, findNavController(R.id.fragment_host))

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
//        val navController = navHostFragment.findNavController()
//        bottomNavigation.setupWithNavController(navController)

//        val navController = findNavController(R.id.fragment_container)
//        setupActionBarWithNavController(navController)
//        navController.addOnDestinationChangedListener { controller, destination, arguments ->
//            destination.label as String
//        }
//        navController.navigateUp()
    }
}