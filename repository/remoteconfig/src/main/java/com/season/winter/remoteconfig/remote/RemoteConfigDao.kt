package com.season.winter.remoteconfig.remote

import com.season.winter.remoteconfig.RemoteConfigManager
import javax.inject.Inject

class RemoteConfigDao @Inject constructor() {

    private val remoteConfigManager = RemoteConfigManager()

    fun refreshConfig() {
        remoteConfigManager.refreshConfig()
    }

}