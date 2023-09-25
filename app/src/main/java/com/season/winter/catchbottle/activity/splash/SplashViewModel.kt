package com.season.winter.catchbottle.activity.splash

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.catchbottle.activity.login.compose.LoginActivity
import com.season.winter.catchbottle.activity.main.compose.MainActivity
import com.season.winter.common.di.sharedPreferences.appConfig.AppConfigRepository
import com.season.winter.common.local.database.image.ImageDatabaseRoomDao
import com.season.winter.remoteconfig.domain.RemoteConfigFetcherUseCase
import com.season.winter.user.di.Credentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val credentials: Credentials,
    private val appConfigRepository: AppConfigRepository,

    // call for initialize
    private val remoteConfigFetcherUseCase: RemoteConfigFetcherUseCase,

    private val fetcherDao: ImageDatabaseRoomDao,
): ViewModel() {

    private val _onLaunchActivityFlow = MutableSharedFlow<Class<out ComponentActivity>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onLaunchActivityFlow: SharedFlow<Class<out ComponentActivity>>
        get() = _onLaunchActivityFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            // launch for booting DB
            fetcherDao.checkForSearchImageData("")
        }
        viewModelScope.launch {
            remoteConfigFetcherUseCase.invoke()
        }
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
            _onLaunchActivityFlow.emit(activity)
        }
    }
}