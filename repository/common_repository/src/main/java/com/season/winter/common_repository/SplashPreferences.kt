package com.season.winter.common_repository

import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore

object SplashPreferences {

    val isFirstLaunch: Boolean get() {
        val isFirst = securePreferences.get(CommonKeyStore.isFirstLaunch, true)
        if (isFirst)
            securePreferences.put(CommonKeyStore.isFirstLaunch, false)
        return isFirst
    }
}
