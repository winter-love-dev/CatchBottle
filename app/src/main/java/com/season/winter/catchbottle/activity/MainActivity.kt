package com.season.winter.catchbottle.activity

import android.os.Bundle
import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.databinding.ActivityMainBinding
import com.season.winter.common.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun ActivityMainBinding.initView() {

    }
}