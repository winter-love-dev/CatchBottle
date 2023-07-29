package com.season.winter.common.local

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences

object AppConfigSharedPreferences {

    private const val name = "AppConfigPreferences" // this::class.java.simpleName.toString()

    @Volatile
    lateinit var instance: Rsa2048Preferences

    fun create(context: Context) {
        if (::instance.isInitialized.not())
            instance = Rsa2048Preferences.create(context, name)
    }
}