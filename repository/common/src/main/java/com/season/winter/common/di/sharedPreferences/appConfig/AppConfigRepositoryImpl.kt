package com.season.winter.common.di.sharedPreferences.appConfig

import com.season.winter.common.local.sharedPreferences.AppConfigDao
import javax.inject.Inject

class AppConfigRepositoryImpl @Inject constructor(
    private val appConfigDao: AppConfigDao
): AppConfigRepository {

    override fun checkFirstLaunch(switchStatusNow: Boolean): Boolean {
        return appConfigDao.checkFirstLaunch(switchStatusNow)
    }
}
