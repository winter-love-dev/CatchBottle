package com.season.winter.catchbottle

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.season.winter.common.local.AppConfigSharedPreferences
import com.season.winter.common.util.sharedPrefrences.securePreferences.AndroidRsaCipherHelper
import com.season.winter.user.local.UserSharedPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application: Application() {

    override fun onCreate() {
        super.onCreate()

//        FireStoreConnectTest().test()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        AndroidRsaCipherHelper.init(this)
        AppConfigSharedPreferences.create(this)
        UserSharedPreferences.create(this)
    }
}