package com.season.winter.common.di

import com.season.winter.common.local.AppConfigDao
import javax.inject.Inject

class AppConfigRepositoryImpl @Inject constructor(
    private val appConfigDao: AppConfigDao
): AppConfigService {

    override fun checkFirstLaunch(switchStatusNow: Boolean): Boolean {
        return appConfigDao.checkFirstLaunch(switchStatusNow)
    }
}
