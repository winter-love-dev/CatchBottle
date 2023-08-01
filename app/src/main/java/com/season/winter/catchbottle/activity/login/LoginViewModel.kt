package com.season.winter.catchbottle.activity.login

import androidx.lifecycle.ViewModel
import com.season.winter.user.di.CredentialsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentials: CredentialsRepositoryImpl
): ViewModel() {

    /*
    * SUSPEND
    * 버퍼 오버플로 시에 일시 중단합니다.
    *
    * DROP_LATEST
    * 오버플로 시에 버퍼에서 **가장 오래된** 값을 삭제하고, 버퍼에 새 값을 추가하고, 일시 중단하지 않습니다.
    *
    * DROP_LATEST
    * 버퍼 오버플로 시에 지금 버퍼에 추가되고 있는 **최신** 값을 삭제하고(버퍼 내용이 동일하게 유지되도록) 일시 중단하지 마십시오.
    */

    private val _onSavedUserNameFlow = MutableSharedFlow<Boolean>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )
    val onSavedUserNameFlow = _onSavedUserNameFlow.asSharedFlow()

    fun login(userName: String) {
        credentials.login(userName)
        _onSavedUserNameFlow.tryEmit(true)
    }
}