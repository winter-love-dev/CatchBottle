package com.season.winter.user.local

import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences
import com.season.winter.user.constants.UserKeyStore
import com.season.winter.user.di.UserPreferencesModule
import javax.inject.Inject

class CBCredentialsDummyDao @Inject constructor(
    @UserPreferencesModule.UserPreferences
    private val preferences: Rsa2048Preferences
) {

    val isLogin: Boolean
        get() = preferences.get(UserKeyStore.isLogin, false)

    val userName: String?
        get() = preferences
            .get(UserKeyStore.userName, "")
            .ifEmpty { null }

    fun login(userName: String) {
        preferences.run {
            put(UserKeyStore.isLogin, true)
            put(UserKeyStore.userName, userName)
        }
    }

    fun logout() {
        preferences.clear()
    }
}
