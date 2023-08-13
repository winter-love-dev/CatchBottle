package com.season.winter.remoteconfig.remote.dao

import android.util.Log
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.remoteconfig.RemoteConfigManager
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteConfigDao @Inject constructor(
    private val remoteConfigManager: RemoteConfigManager
) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val _onBannerConfigData = MutableSharedFlow<List<BannerData>>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onBannerConfigDataFlow: SharedFlow<List<BannerData>>
        get() = _onBannerConfigData.asSharedFlow()

    init {
        coroutineScope.launch {
            remoteConfigManager.onBannerConfigFlow.collect { bannerJsonString ->
                val result = bannerJsonString
                    .decodeFromJsonStringSafety<List<BannerData>>() ?: return@collect
                _onBannerConfigData.tryEmit(result)
            }
        }
        coroutineScope.launch {
            remoteConfigManager.onSomeOtherConfig.collect { someOtherConfig ->
                Log.e(TAG, "_someOtherConfig: $someOtherConfig", )
            }
        }
    }

    fun refreshConfig() {
        remoteConfigManager.refreshConfig()
    }

    companion object {

        private const val TAG = "RemoteConfigDao"
    }
}