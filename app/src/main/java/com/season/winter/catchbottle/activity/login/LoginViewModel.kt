package com.season.winter.catchbottle.activity.login

import androidx.lifecycle.ViewModel
import com.season.winter.user.di.CredentialsRepositoryImpl
import com.season.winter.user.local.CBCredentialsDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val credentials: CredentialsRepositoryImpl
): ViewModel() {

    var onSavedUserNameFlow = MutableStateFlow(false)

    fun login(userName: String) {
        credentials.login(userName)
        onSavedUserNameFlow.value = true
    }
}