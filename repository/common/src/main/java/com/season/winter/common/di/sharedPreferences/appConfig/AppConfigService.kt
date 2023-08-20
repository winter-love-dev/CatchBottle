package com.season.winter.common.di.sharedPreferences.appConfig

interface AppConfigService {
    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean
}
