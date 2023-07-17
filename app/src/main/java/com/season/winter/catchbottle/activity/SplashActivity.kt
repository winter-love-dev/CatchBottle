package com.season.winter.catchbottle.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.season.winter.common.extention.activity.startActivitySimpleTransition

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        startActivitySimpleTransition(MainActivity::class.java)
        finish()
    }
}