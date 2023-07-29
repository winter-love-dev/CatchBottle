package com.season.winter.common.di

interface AppConfigService {
    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean
}
