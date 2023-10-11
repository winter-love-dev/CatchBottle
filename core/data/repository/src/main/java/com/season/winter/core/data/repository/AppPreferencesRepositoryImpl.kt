package com.season.winter.core.data.repository

import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048PreferencesDao
import com.season.winter.core.data.repository.constants.CommonKeyStore
import com.season.winter.core.data.repository.di.preferences.AppPreferencesModule
import com.season.winter.core.domain.repository.AppPreferencesRepository
import javax.inject.Inject

class AppPreferencesRepositoryImpl @Inject constructor(
    @AppPreferencesModule.AppConfigPreferences
    private val preferences: Rsa2048PreferencesDao
): AppPreferencesRepository {

    override val isFirstLaunch: Boolean
        get() = preferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (isFirst)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }

    override fun checkFirstLaunch(switchStatusNow: Boolean): Boolean {
        return preferences.run {
            val isFirst = get(CommonKeyStore.isFirstLaunch, true)
            if (switchStatusNow)
                put(CommonKeyStore.isFirstLaunch, false)
            isFirst
        }
    }
}
