package com.season.winter.catchbottle.activity.main.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.season.winter.catchbottle.activity.login.compose.LoginActivity
import com.season.winter.catchbottle.activity.search.SearchActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.compose.theme.ComposeCatchBottleTheme
import com.season.winter.feature.main.navigation.MainBottomBar
import com.season.winter.feature.main.navigation.MainNavHost
import com.season.winter.feature.main.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.extensions.keyboard.state.MutableExKeyboardStateSource
import tech.thdev.compose.extensions.keyboard.state.foundation.removeFocusWhenKeyboardIsHidden
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        repeatOnLifecycle(viewModel.onLogoutListener) {
            if (it) {
                cbStartActivity(LoginActivity::class.java, true)
            }
        }
        repeatOnLifecycle(viewModel.onClickSearchListener) {
            if (it) {
                cbStartActivity(SearchActivity::class.java, false)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainActivityScreen()
        }
    }
}

@Composable
fun MainActivityScreen() {
    val navController = rememberNavController()

    CompositionLocalProvider(
        LocalMutableExKeyboardStateSourceOwner provides MutableExKeyboardStateSource(),
    ) {
        Scaffold(
            modifier = Modifier
                .removeFocusWhenKeyboardIsHidden(),
            content = { scaffoldPadding ->
                MainNavHost(navController, Modifier.padding(scaffoldPadding))
            },
            bottomBar = {
                MainBottomBar(navController)
            }
        )
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
internal fun PreviewMainActivityScreen() {
    ComposeCatchBottleTheme {
        MainActivityScreen()
    }
}


