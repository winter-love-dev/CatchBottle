package com.season.winter.common.util.sharedPrefrences.factory

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences

class SharedPreferencesFactory: SharedPreferencesFactoryService {

    override fun createRsa2048SharedPreferences(context: Context, name: String): Rsa2048Preferences {
        return Rsa2048Preferences.create(context, name)
    }
}

