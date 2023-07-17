package com.season.winter.catchbottle.activity.login

import androidx.lifecycle.ViewModel
import com.season.winter.user_repository.CBCredentials
import kotlinx.coroutines.flow.MutableStateFlow

//@HiltViewModel
class LoginViewModel /*@Inject constructor()*/: ViewModel() {

    var onSavedUserNameFlow = MutableStateFlow(false)

    fun login(userName: String) {
        CBCredentials.login(userName)
        onSavedUserNameFlow.value = true
    }
}