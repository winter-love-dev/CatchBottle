package com.season.winter.catchbottle

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application: Application(), Configuration.Provider {

    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder()
            .setMinimumLoggingLevel(
//                if (BuildConfig.DEBUG) android.util.Log.DEBUG
//                else
                    android.util.Log.ERROR
            )
            .build()

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}