package com.season.winter.remoteconfig.di


import com.season.winter.remoteconfig.RemoteConfig
import com.season.winter.remoteconfig.getConfig
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

object RemoteConfigKey {
    const val KeyBanner = "Banner"
    const val KeySomeOther = "SomeOtherConfig"

    val KeyAll = listOf(KeyBanner, KeySomeOther)
}

class RemoteConfigServiceImpl @Inject constructor(
    private val remoteConfig: RemoteConfig,
): RemoteConfigService {

    init {
        remoteConfig.announceFetched = { keys ->
            onFetchSuccess(keys)
        }
    }

    override suspend fun fetch(): Boolean {
        return remoteConfig.fetch()
    }

    override var announceFetched: ((keys: List<String>) -> Unit)? = null

    override fun onFetchSuccess(keys: List<String>) {
        if (keys.isEmpty()) return
        announceFetched?.invoke(keys)
    }

    override fun getString(key: String): String? {
        return remoteConfig.getConfig<String>(key)
    }

    override fun getInt(key: String): Int? {
        return remoteConfig.getConfig<Long>(key)?.toInt()
    }

    override fun getDouble(key: String): Double? {
        return remoteConfig.getConfig<Double>(key)
    }

    override fun getBoolean(key: String): Boolean? {
        return remoteConfig.getConfig<Boolean>(key)
    }

    override fun getLong(key: String): Long? {
        return remoteConfig.getConfig<Long>(key)
    }

    companion object {

        private const val TAG = "RemoteConfigImpl"
    }
}