package com.season.winter.common.util.sharedPrefrences.factory

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences

interface SharedPreferencesFactoryService {
    fun createRsa2048SharedPreferences(context: Context, name: String): Rsa2048Preferences
}

