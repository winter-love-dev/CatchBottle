package com.season.winter.user.local

import com.season.winter.user.constants.UserKeyStore
import javax.inject.Inject

class CBCredentialsDao @Inject constructor() {

    private val sharedPreferences = UserSharedPreferences.instance

    val isLogin: Boolean
        get() = sharedPreferences
            .get(UserKeyStore.isLogin, false)

    val userName: String?
        get() = UserSharedPreferences.instance
            .get(UserKeyStore.userName, "")
            .ifEmpty { null }

    fun login(userName: String) {
        UserSharedPreferences.instance.run {
            put(UserKeyStore.isLogin, true)
            put(UserKeyStore.userName, userName)
        }
    }

    fun logout() {
        UserSharedPreferences.instance.clear()
    }
}
