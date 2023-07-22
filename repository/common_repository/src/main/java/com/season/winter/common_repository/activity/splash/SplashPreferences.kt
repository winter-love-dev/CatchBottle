package com.season.winter.common_repository.activity.splash

import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore

class SplashPreferences {
    val isFirstLaunch: Boolean
        get() = securePreferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (isFirst)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }
}
