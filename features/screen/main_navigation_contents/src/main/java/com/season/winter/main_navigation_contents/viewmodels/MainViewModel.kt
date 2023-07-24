package com.season.winter.main_navigation_contents.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences
import com.season.winter.user_repository.CBCredentials
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class MainViewModel: ViewModel() {

    private val credentials = CBCredentials()
    var count = 0
    val onCountFlow = MutableStateFlow(0)

    val userName = MutableStateFlow(credentials.userName)

    private val _onLogoutListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onLogoutListener: SharedFlow<Boolean> get() = _onLogoutListener.asSharedFlow()

    fun countUp() {
        count+=1
        onCountFlow.value = count
    }

    fun printCount() {
        Log.e("TAG", "printCount: count: $count", )
    }

    fun onLogout() {
        SecureSharedPreferences.securePreferences.clear()
        _onLogoutListener.tryEmit(true)
    }

}