package com.season.winter.user.local

import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.UserKeyStore
import javax.inject.Inject

class CBCredentialsDao @Inject constructor() {

    val isLogin: Boolean
        get() = securePreferences
            .get(UserKeyStore.isLogin, false)

    val userName: String?
        get() = securePreferences
            .get(UserKeyStore.userName, "")
            .ifEmpty { null }

    fun login(userName: String) {
        securePreferences.run {
            put(UserKeyStore.isLogin, true)
            put(UserKeyStore.userName, userName)
        }
    }

    fun logout() {
        securePreferences.clear()
    }
}
