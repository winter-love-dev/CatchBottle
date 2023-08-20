package com.season.winter.main_navigation_contents.viewmodels

import androidx.lifecycle.ViewModel
import com.season.winter.liquor.dummy.model.HomeItem
import com.season.winter.screen.fragment.navigationMain.home.di.HomeNavigationRepositoryImpl
import com.season.winter.user.di.Credentials
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainNavigationViewModel @Inject constructor(
    private val credentials: Credentials,
    private val dummyRepository: HomeNavigationRepositoryImpl,
): ViewModel() {

    val userName = MutableStateFlow(credentials.userName)

    private val _onLogoutListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onLogoutListener: SharedFlow<Boolean>
        get() = _onLogoutListener.asSharedFlow()

    private val _onClickSearchListener = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onClickSearchListener: SharedFlow<Boolean>
        get() = _onClickSearchListener.asSharedFlow()

    val mainListFlow = dummyRepository.mainListFlow

    fun getMainList() {
        dummyRepository.getMainListFlow()
    }

    fun onLogout() {
        credentials.logout()
        _onLogoutListener.tryEmit(true)
    }

    fun onClickSearch() {
        _onClickSearchListener.tryEmit(true)
    }
}