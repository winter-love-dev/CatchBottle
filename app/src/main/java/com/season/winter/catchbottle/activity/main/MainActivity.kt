package com.season.winter.catchbottle.activity.main

import android.os.Bundle
import android.util.Log
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import com.season.winter.common.util.sharedPrefrences.SecureSharedPreferences.Companion.securePreferences
import com.season.winter.config.sharedPrefences.CommonKeyStore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    override fun ActivityMainBinding.initView() {
        securePreferences.put(CommonKeyStore.userName, "string")
        securePreferences.put(CommonKeyStore.isLogin, false)
        securePreferences.put(CommonKeyStore.isFirstLaunch, false)
        securePreferences.put(CommonKeyStore.count, 1)
        Log.e("TAG", "initView: userName: ${securePreferences.get(CommonKeyStore.userName, "")}", )
        Log.e("TAG", "initView: isLogin: ${securePreferences.get(CommonKeyStore.isLogin, true)}", )
        Log.e("TAG", "initView: isFirstLaunch: ${securePreferences.get(CommonKeyStore.isFirstLaunch, true)}", )
        Log.e("TAG", "initView: count: ${securePreferences.get(CommonKeyStore.count, 0)}", )
    }
}