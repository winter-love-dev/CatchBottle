package com.season.winter.catchbottle.activity.login

import androidx.lifecycle.ViewModel
import com.season.winter.user.CBCredentials
import kotlinx.coroutines.flow.MutableStateFlow

//@HiltViewModel
class LoginViewModel /*@Inject constructor()*/: ViewModel() {

    private val credentials = com.season.winter.user.CBCredentials()

    var onSavedUserNameFlow = MutableStateFlow(false)

    fun login(userName: String) {
        credentials.login(userName)
        onSavedUserNameFlow.value = true
    }
}