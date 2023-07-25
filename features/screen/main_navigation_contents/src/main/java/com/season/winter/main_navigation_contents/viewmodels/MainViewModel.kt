package com.season.winter.main_navigation_contents.viewmodels

import androidx.lifecycle.ViewModel
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences
import com.season.winter.ui.dummy.HomeUIDummyGenerator
import com.season.winter.ui.fragment.home.HomeItem
import com.season.winter.user_repository.CBCredentials
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val homeUIDataDummyGenerator: HomeUIDummyGenerator = HomeUIDummyGenerator()
): ViewModel() {

    private val credentials = CBCredentials()

    val userName = MutableStateFlow(credentials.userName)

    private val _onLogoutListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onLogoutListener: SharedFlow<Boolean>
        get() = _onLogoutListener.asSharedFlow()

    private val _onHomeUiDataListener = MutableStateFlow(
        homeUIDataDummyGenerator.mainList
    )

    val onHomeUiDataListener: StateFlow<List<HomeItem>>
        get() = _onHomeUiDataListener.asStateFlow()

    fun onLogout() {
        SecureSharedPreferences.securePreferences.clear()
        _onLogoutListener.tryEmit(true)
    }
}