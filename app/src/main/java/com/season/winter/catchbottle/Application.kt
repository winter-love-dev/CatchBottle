package com.season.winter.catchbottle

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.season.winter.common.util.sharedPrefrences.AndroidRsaCipherHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application: Application() {

    override fun onCreate() {
        super.onCreate()
//        FireStoreConnectTest().test()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        AndroidRsaCipherHelper.init(this)
    }

}