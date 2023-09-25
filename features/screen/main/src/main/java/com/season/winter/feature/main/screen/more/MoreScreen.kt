package com.season.winter.feature.main.screen.more

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.season.winter.compose.button.CBButton
import com.season.winter.compose.spacing.CBColumnWeight
import com.season.winter.compose.text.CBText
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.designsystem.spacing.CBSpacing
import com.season.winter.feature.main.navigation.NavGraph
import com.season.winter.feature.main.viewmodel.MainActivityViewModel


/*
@Composable
fun MoreScreen(
    activityViewModel: MainActivityViewModel = hiltViewModel()
) {
    MoreScreen(
        onClickLogout = {
            activityViewModel.onClickLogout()
        }
    )
}
*/

@Composable
internal fun MoreScreen(
    onClickLogout: () -> Unit
) {
    Column(
        modifier = Modifier.padding(CBSpacing.M.dp)
    ) {
        CBText(text = NavGraph.More.route)
        CBColumnWeight()
        CBButton("Logout") {
            onClickLogout()
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@ExperimentalComposeUiApi
@Composable
internal fun PreviewMoreScreen() {
    ComposeCatchBottleTheme {
        MoreScreen(
            onClickLogout = {

            }
        )
    }
}