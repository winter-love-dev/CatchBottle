package com.season.winter.catchbottle.activity.search

import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.databinding.ActivitySearchBinding
import com.season.winter.common.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity: BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {

    override fun ActivitySearchBinding.initView() {
        activity = this@SearchActivity
    }

    fun onClickCloseButton() {
        finish()
    }
}