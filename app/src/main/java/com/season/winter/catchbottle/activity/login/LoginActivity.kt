package com.season.winter.catchbottle.activity.login

import com.season.winter.catchbottle.R
import com.season.winter.catchbottle.databinding.ActivityLoginBinding
import com.season.winter.common.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels
import com.season.winter.catchbottle.activity.main.MainActivity
import com.season.winter.common.extention.activity.cbStartActivity
import com.season.winter.common.extention.coroutine.cbWhenStarted
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity: BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val viewModel: LoginViewModel by viewModels()

    override fun ActivityLoginBinding.initView() {
        coroutine.launch {
            cbWhenStarted {
                viewModel.onSavedUserNameFlow.collect { isSaved ->
                    if(isSaved)
                        cbStartActivity(MainActivity::class.java)
                }
            }
        }
        loginButton.setOnClickListener {
            nameEditText.text.run {
                if (this.isNotEmpty())
                    viewModel.login(this.toString())
            }
        }
    }
}