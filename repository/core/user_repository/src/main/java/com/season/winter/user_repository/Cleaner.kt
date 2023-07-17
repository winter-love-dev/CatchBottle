package com.season.winter.user_repository

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.clearAllPreferences

fun Context.clearPreferencesForLogout() {
    clearAllPreferences()
}