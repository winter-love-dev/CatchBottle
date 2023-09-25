package com.season.winter.feature.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.season.winter.feature.main.screen.home.HomeScreen
import com.season.winter.feature.main.screen.map.MapScreen
import com.season.winter.feature.main.screen.more.MoreScreen
import com.season.winter.feature.main.screen.wishlist.WishListScreen
import com.season.winter.feature.main.viewmodel.MainActivityViewModel

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    activityViewModel: MainActivityViewModel = hiltViewModel()
) {
    NavHost(
        navController,
        startDestination = NavGraph.Home.route,
        modifier = modifier,
//        enterTransition = { fadeIn(animationSpec = tween(0)) },
//        exitTransition = { fadeOut(animationSpec = tween(0)) },
    ) {
        composable(NavGraph.Home.route) {
            HomeScreen(

            )
        }
        composable(NavGraph.Map.route) {
            MapScreen()
        }
        composable(NavGraph.WishList.route) {
            WishListScreen()
        }
        composable(NavGraph.More.route) {
            MoreScreen(
                onClickLogout = {
                    activityViewModel.onClickLogout()
                }
            )
        }
    }
}