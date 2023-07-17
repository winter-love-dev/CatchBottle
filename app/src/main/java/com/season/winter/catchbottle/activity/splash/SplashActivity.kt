package com.season.winter.catchbottle.activity.splash

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.extention.activity.startActivitySimpleTransition
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)



        exit()
    }

    private fun exit() {
        startActivitySimpleTransition(MainActivity::class.java)
        finish()
    }
}