package com.season.winter.common_repository

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.clearAllPreferences
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore

fun Context.clearPreferencesForCommon() {

    // 유지할 데이터 킵하기
    val isFirstLaunch = securePreferences.get(CommonKeyStore.isFirstLaunch, false)
//    val someSetting1 = SecureSharedPreferences.securePreferences.get(CommonKeyStore.isFirstLaunch, false)
//    val someSetting2 = SecureSharedPreferences.securePreferences.get(CommonKeyStore.isFirstLaunch, false)
//    val someSetting3 = SecureSharedPreferences.securePreferences.get(CommonKeyStore.isFirstLaunch, false)

    clearAllPreferences()

    // 킵 해둔 값 입력하기
    securePreferences.put(CommonKeyStore.isFirstLaunch, isFirstLaunch)
}
