package com.season.winter.core.data.repository

import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048PreferencesDao
import com.season.winter.core.data.repository.constants.UserKeyStore
import com.season.winter.core.data.repository.di.preferences.UserPreferencesModule
import com.season.winter.core.domain.repository.CredentialsDummyRepository
import javax.inject.Inject

class CredentialsDummyRepositoryImpl @Inject constructor(
    @UserPreferencesModule.UserPreferences
    private val preferences: Rsa2048PreferencesDao
): CredentialsDummyRepository {

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
