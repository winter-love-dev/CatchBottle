package com.season.winter.catchbottle.activity.splash

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.di.AppConfigRepositoryImpl
import com.season.winter.firestore.FireStoreConnectTest
import com.season.winter.user.di.Credentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val credentials: Credentials,
    private val appConfigRepository: AppConfigRepositoryImpl
): ViewModel() {

    val onLaunchActivityFlow = MutableSharedFlow<Class<out BaseActivity<out ViewDataBinding>>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    fun fireStoreTest() {
        FireStoreConnectTest().test()
    }

    fun checkLaunchTargetActivity() {
        val isFirstLaunch = appConfigRepository.checkFirstLaunch(true)
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