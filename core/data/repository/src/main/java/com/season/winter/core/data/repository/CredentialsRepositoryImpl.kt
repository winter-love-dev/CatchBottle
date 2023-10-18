package com.season.winter.core.data.repository

import com.season.winter.common.util.sharedPrefrences.CatchBottleSharedPreferences
import com.season.winter.core.data.repository.constants.UserKeyStore
import com.season.winter.core.data.repository.di.preferences.SharedPreferencesModule
import com.season.winter.core.domain.repository.CredentialsRepository
import javax.inject.Inject

class CredentialsRepositoryImpl @Inject constructor(
    @SharedPreferencesModule.CredentialsPreferencesInstance
    private val preferences: CatchBottleSharedPreferences
): CredentialsRepository {

    override val isLogin: Boolean
        get() = preferences.get(UserKeyStore.isLogin, false)

    override val userName: String?
        get() = preferences
            .get(UserKeyStore.userName, "")
            .ifEmpty { null }

    override fun login(userName: String) {
        preferences.run {
            put(UserKeyStore.isLogin, true)
            put(UserKeyStore.userName, userName)
        }
    }

    override fun logout() {
        preferences.clear()
    }
}
