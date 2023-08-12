package com.season.winter.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.season.winter.common.constants.TimeVariable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RemoteConfigManager @Inject constructor() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val remoteConfig = Firebase.remoteConfig
    private val configSettings = remoteConfigSettings {
//        minimumFetchIntervalInSeconds =  if (isDebugMode) TimeVariable.Min1.value else TimeVariable.Hour1.value
        minimumFetchIntervalInSeconds = TimeVariable.Zero.value
    }

    private val _onBannerConfigFlow = MutableSharedFlow<String>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onBannerConfigFlow: SharedFlow<String>
        get() = _onBannerConfigFlow.asSharedFlow()


    private val _onSomeOtherConfig = MutableSharedFlow<String>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val onSomeOtherConfig: SharedFlow<String>
        get() = _onSomeOtherConfig.asSharedFlow()


    init {
        remoteConfig.let { config ->
            config.setConfigSettingsAsync(configSettings)
            config.setDefaultsAsync(R.xml.remote_config_defaults)

            // listen live update
            config.addOnConfigUpdateListener(object : ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    config.activate().addOnCompleteListener { newConfig ->
                        if (newConfig.isSuccessful.not())
                            return@addOnCompleteListener

                        configUpdate.updatedKeys.run {
                            when {
                                contains(KeyBanner) -> {
                                    Log.e(TAG, "onUpdate: $KeyBanner", )
                                    emitBanner()
                                }
                                contains(KeySomeOther) -> {
                                    Log.e(TAG, "onUpdate: $KeySomeOther", )
                                    emitSomeOtherConfig()
                                }
                            }
                        }
                    }
                }
                override fun onError(error : FirebaseRemoteConfigException) {
                    Log.e(TAG, "update error with code: " + error.code, error)
                }
            })
        }
    }

    fun refreshConfig() {
        coroutineScope.launch {
            remoteConfig.fetchAndActivate().await()
            emitAllConfig()
        }
    }

    private fun emitAllConfig() {
        emitBanner()
        emitSomeOtherConfig()
    }

    private fun emitBanner() {
        val newConfig = remoteConfig.getString(KeyBanner)
        Log.e(TAG, "emitBanner: newConfig :$newConfig", )
        _onBannerConfigFlow.tryEmit(newConfig)
    }

    private fun emitSomeOtherConfig() {
        val newConfig = remoteConfig.getString(KeySomeOther)
        Log.e(TAG, "emitSomeOtherConfig: newConfig :$newConfig", )
        _onSomeOtherConfig.tryEmit(newConfig)
    }

    companion object {

        private const val TAG = "RemoteConfigManager"

        private const val KeyBanner = "Banner"
        private const val KeySomeOther = "SomeOtherConfig"
    }
}