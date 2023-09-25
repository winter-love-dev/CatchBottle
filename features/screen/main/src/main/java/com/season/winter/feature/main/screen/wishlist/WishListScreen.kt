package com.season.winter.feature.main.screen.wishlist

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.feature.main.navigation.NavGraph
import com.season.winter.feature.main.viewmodel.MainActivityViewModel


@Composable
fun WishListScreen(
    navController: NavHostController,
    activityViewModel: MainActivityViewModel = hiltViewModel()
) {
    WishListScreen(
        onClickSearchBar = {

        }
    )
}

@Composable
internal fun WishListScreen(
    onClickSearchBar: () -> Unit = { }
) {
    CBText(text = NavGraph.WishList.route)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@ExperimentalComposeUiApi
@Composable
internal fun PreviewWishListScreen() {
    ComposeCatchBottleTheme {
        WishListScreen(
            onClickSearchBar = {

            }
        )
    }
}