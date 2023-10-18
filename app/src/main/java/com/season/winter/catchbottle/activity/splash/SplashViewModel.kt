package com.season.winter.catchbottle.activity.splash

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.catchbottle.activity.login.compose.LoginActivity
import com.season.winter.catchbottle.activity.main.compose.MainActivity
import com.season.winter.core.domain.database.ImageDatabaseRoomDao
import com.season.winter.core.domain.repository.AppPreferencesRepository
import com.season.winter.core.domain.repository.CredentialsRepository
import com.season.winter.core.domain.usecase.RemoteConfigFetcherUseCase
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
    private val credentials: CredentialsRepository,
    private val appPreferencesRepository: AppPreferencesRepository,

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
        val isFirstLaunch = appPreferencesRepository.checkFirstLaunch(true)
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