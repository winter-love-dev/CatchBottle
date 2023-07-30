package com.season.winter.common.local

import com.season.winter.common.constants.CommonKeyStore
import javax.inject.Inject

class AppConfigDao @Inject constructor() {

    private val isFirstLaunch: Boolean
        get() = AppConfigSharedPreferences.instance.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (isFirst)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }

    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean {
        return AppConfigSharedPreferences.instance.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (switchStatusNow)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }
    }
}