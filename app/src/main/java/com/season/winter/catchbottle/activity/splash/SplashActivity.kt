package com.season.winter.catchbottle.activity.splash

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.season.winter.catchbottle.activity.login.LoginActivity
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common_repository.SplashPreferences.isFirstLaunch
import com.season.winter.user_repository.CBCredentials

@SuppressLint("CustomSplashScreen")
class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        // refresh remote config ...
        checkLaunchTargetActivity()
    }

    private fun checkLaunchTargetActivity() {
        when {
            isFirstLaunch || !CBCredentials.isLogin ->
                cbStartActivity(LoginActivity::class.java)

            else ->
                cbStartActivity(MainActivity::class.java)
        }
    }

}