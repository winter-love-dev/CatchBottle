package com.season.winter.core.domain.repository

interface AppPreferencesRepository {
    val isFirstLaunch: Boolean
    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean
}
