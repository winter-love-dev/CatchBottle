package com.season.winter.remoteconfig.di


import com.season.winter.remoteconfig.RemoteConfig
import com.season.winter.remoteconfig.getConfig
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class RemoteConfigImpl @Inject constructor(
    private val remoteConfig: RemoteConfig
): RemoteConfigService {

    init {
        remoteConfig.announceFetched = { keys ->
            announceFetched(keys)
        }
    }

    private val _onFetchSuccessFlow = MutableSharedFlow<List<String>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    override val onFetchSuccessFlow: SharedFlow<List<String>>
        get() = _onFetchSuccessFlow.asSharedFlow()

    override suspend fun fetch(): Boolean {
        return remoteConfig.fetch()
    }

    override fun announceFetched(keys: List<String>) {
        if (keys.isEmpty()) return
        _onFetchSuccessFlow.tryEmit(keys)
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

        const val KeyBanner = "Banner"
        const val KeySomeOther = "SomeOtherConfig"

        val KeyAll = listOf(KeyBanner, KeySomeOther)
    }
}