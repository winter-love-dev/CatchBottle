package com.season.winter.user_repository

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.UserKeyStore


object Credentials {
    val userName: String?
        get() = securePreferences
            .get(UserKeyStore.userName, "")
            .ifEmpty { null }

    fun saveUserName(userName: String) {
        securePreferences.put(UserKeyStore.userName, userName)
    }

    fun logout(context: Context) {
        context.clearPreferencesForLogout()
    }
}
