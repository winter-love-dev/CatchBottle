package com.season.winter.common.local

import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences
import com.season.winter.common.constants.CommonKeyStore
import com.season.winter.common.di.AppConfigPreferencesModule
import javax.inject.Inject

class AppConfigDao @Inject constructor(
    @AppConfigPreferencesModule.AppConfigPreferences
    private val preferences: Rsa2048Preferences
) {

    private val isFirstLaunch: Boolean
        get() = preferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (isFirst)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }

    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean {
        return preferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (switchStatusNow)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }
    }
}