package com.season.winter.remoteconfig.di

import kotlinx.coroutines.flow.SharedFlow

interface RemoteConfigService {

    val onFetchSuccessFlow: SharedFlow<List<String>>

    suspend fun fetch(): Boolean

    fun announceFetched(keys: List<String>)

    fun getString(key: String): String?
    fun getDouble(key: String): Double?
    fun getBoolean(key: String): Boolean?
    fun getLong(key: String): Long?

}