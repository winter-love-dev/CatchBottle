package com.season.winter.feature.main.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.feature.main.navigation.NavGraph
import com.season.winter.feature.main.viewmodel.MainActivityViewModel

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    navController: NavHostController,
    activityViewModel: MainActivityViewModel = hiltViewModel()
) {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//    val route = currentDestination?.route ?: ""
//    Log.e(TAG, "HomeScreen: route: $route")

    HomeScreen(
        onClickSearchBar = {
            activityViewModel.onClickSearch()
        }
    )
}

@Composable
internal fun HomeScreen(
    onClickSearchBar: () -> Unit = { }
) {
    Column {
        CBText(text = NavGraph.Home.route)
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@ExperimentalComposeUiApi
@Composable
internal fun PreviewHomeScreen() {
    ComposeCatchBottleTheme {
        HomeScreen(
            onClickSearchBar = {

            }
        )
    }
}