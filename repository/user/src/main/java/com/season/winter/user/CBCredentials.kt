package com.season.winter.user

import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.UserKeyStore


class CBCredentials {

    val isLogin: Boolean get() =
        securePreferences.get(UserKeyStore.isLogin, false)

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
}
