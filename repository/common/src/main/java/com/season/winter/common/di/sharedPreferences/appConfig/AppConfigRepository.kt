package com.season.winter.common.di.sharedPreferences.appConfig

interface AppConfigRepository {
    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean
}
