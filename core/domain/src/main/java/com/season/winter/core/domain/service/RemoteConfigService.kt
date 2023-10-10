package com.season.winter.core.domain.service


interface RemoteConfigService {

    suspend fun fetch(): Boolean

    var announceFetched: ((keys: List<String>) -> Unit)?

    fun onFetchSuccess(keys: List<String>)

    fun getString(key: String): String?

    fun getInt(key: String): Int?

    fun getDouble(key: String): Double?
    fun getBoolean(key: String): Boolean?
    fun getLong(key: String): Long?

}