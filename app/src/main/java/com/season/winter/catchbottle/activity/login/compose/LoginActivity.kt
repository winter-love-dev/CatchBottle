package com.season.winter.catchbottle.activity.login.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.season.winter.feature.login.LoginViewModel
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.repeatOnLifecycle
import com.season.winter.feature.login.LoginActivityScreen
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.extensions.keyboard.state.MutableExKeyboardStateSource
import tech.thdev.compose.extensions.keyboard.state.foundation.removeFocusWhenKeyboardIsHidden
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner

@AndroidEntryPoint
class LoginActivity: ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()

        repeatOnLifecycle(viewModel.onSavedUserNameFlow) { isSaved ->
            if(isSaved)
                cbStartActivity(MainActivity::class.java, true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CompositionLocalProvider(
                LocalMutableExKeyboardStateSourceOwner provides MutableExKeyboardStateSource(),
            ) {
                Scaffold(
                    modifier = Modifier
                        .removeFocusWhenKeyboardIsHidden()
                ) { scaffoldPadding ->
                    Box(modifier = Modifier.padding(scaffoldPadding)) {
                        LoginActivityScreen()
                    }
                }
            }
        }
    }
}