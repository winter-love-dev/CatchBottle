package com.season.winter.core.domain.repository

interface AppPreferencesRepository {
    fun checkFirstLaunch(switchStatusNow: Boolean): Boolean
}
