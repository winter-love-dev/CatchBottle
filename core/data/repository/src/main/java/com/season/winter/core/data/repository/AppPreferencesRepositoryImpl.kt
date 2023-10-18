package com.season.winter.core.data.repository

import com.season.winter.common.util.sharedPrefrences.CatchBottleSharedPreferences
import com.season.winter.core.data.repository.constants.CommonKeyStore
import com.season.winter.core.data.repository.di.preferences.SharedPreferencesModule
import com.season.winter.core.domain.repository.AppPreferencesRepository
import javax.inject.Inject

class AppPreferencesRepositoryImpl @Inject constructor(
    @SharedPreferencesModule.AppConfigPreferencesInstance
    private val preferences: CatchBottleSharedPreferences
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
