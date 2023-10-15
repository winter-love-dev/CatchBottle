package com.season.winter.feature.main.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(
            route = NavGraph.Home.route
        ) {
            HomeScreen(

            )
        }
        composable(
            route = NavGraph.Map.route
        ) {
            MapScreen()
        }
        composable(
            route = NavGraph.WishList.route
        ) {
            WishListScreen()
        }
        composable(
            route = NavGraph.More.route
        ) {
            MoreScreen(
                onClickLogout = {
                    activityViewModel.onClickLogout()
                }
            )
        }
    }
}