package com.season.winter.feature.main.screen.map

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
fun MapScreen(
    navController: NavHostController,
    activityViewModel: MainActivityViewModel = hiltViewModel()
) {
    MapScreen(
        onClickSearchBar = {

        }
    )
}

@Composable
internal fun MapScreen(
    onClickSearchBar: () -> Unit = { }
) {
    CBText(text = NavGraph.Map.route)
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@ExperimentalComposeUiApi
@Composable
internal fun PreviewMapScreen() {
    ComposeCatchBottleTheme {
        MapScreen(
            onClickSearchBar = {

            }
        )
    }
}