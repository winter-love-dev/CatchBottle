package com.season.winter.catchbottle.activity.splash

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore
import com.season.winter.user.CBCredentials
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private val credentials = CBCredentials()

    private val isFirstLaunch: Boolean
        get() = SecureSharedPreferences.securePreferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (isFirst)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }

    val onLaunchActivityFlow = MutableSharedFlow<Class<out BaseActivity<out ViewDataBinding>>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    fun checkLaunchTargetActivity() {
        val activity = when {
            isFirstLaunch || !credentials.isLogin ->
                LoginActivity::class.java

            else ->
                MainActivity::class.java
        }
        viewModelScope.launch {
            delay(500)
            onLaunchActivityFlow.emit(activity)
        }
    }
}