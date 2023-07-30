package com.season.winter.user.local

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences

object UserSharedPreferences {

    private const val name = "UserSharedPreferences"

    @Volatile
    lateinit var instance: Rsa2048Preferences

    fun create(context: Context) {
        if (::instance.isInitialized.not())
            instance = Rsa2048Preferences.create(context, name)
    }
}