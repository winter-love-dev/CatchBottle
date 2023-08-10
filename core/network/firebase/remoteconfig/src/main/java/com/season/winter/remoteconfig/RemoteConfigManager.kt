package com.season.winter.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.season.winter.common.constants.TimeVariable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class RemoteConfigManager {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val remoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    private val configSettings = remoteConfigSettings {
//        minimumFetchIntervalInSeconds =  if (isDebugMode) TimeVariable.Min1.value else TimeVariable.Hour1.value
        minimumFetchIntervalInSeconds = TimeVariable.Zero.value
    }

    init {
        remoteConfig.let { config ->
            config.setConfigSettingsAsync(configSettings)
            config.setDefaultsAsync(R.xml.remote_config_defaults)
            config.addOnConfigUpdateListener(object : ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    if (configUpdate.updatedKeys.contains("Banner")) {
                        config.activate().addOnCompleteListener { result ->
                            Log.e(TAG, "onUpdate: result: $result", )
                        }
                    }
                }

                override fun onError(error : FirebaseRemoteConfigException) {
                    Log.e(TAG, "Config update error with code: " + error.code, error)
                }
            })
        }
    }

    fun refreshConfig() {
        coroutineScope.launch {
            remoteConfig.fetchAndActivate().await()
            getBannerConfig(remoteConfig)
        }
    }

    private fun getBannerConfig(config: FirebaseRemoteConfig) {
        val string = config.getString("Banner")
        Log.e(TAG, "getBannerConfig: string: $string", )
    }

    companion object {
        private const val TAG = "RemoteConfigManager"
    }
}