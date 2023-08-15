package com.season.winter.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.season.winter.common.constants.TimeVariable
import com.season.winter.remoteconfig.di.RemoteConfigImpl.Companion.KeyAll
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.reflect.typeOf

class RemoteConfig @Inject constructor() {

    private val instance = Firebase.remoteConfig

    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = TimeVariable.Zero.value
    }

    var announceFetched: ((keys: List<String>) -> Unit)? = null

    init {
        instance.let { config ->
            config.setConfigSettingsAsync(configSettings)
            config.setDefaultsAsync(R.xml.remote_config_defaults)

            // setOnLiveConfigUpdateListener
            config.addOnConfigUpdateListener(object: ConfigUpdateListener {
                override fun onUpdate(configUpdate: ConfigUpdate) {
                    config.activate().addOnCompleteListener { newConfig ->

                        if (newConfig.isSuccessful.not())
                            return@addOnCompleteListener

                        val updateKeys = mutableListOf<String>()

                        KeyAll.forEach { key ->
                            if (configUpdate.updatedKeys.contains(key))
                                updateKeys.add(key)
                        }

                        announceFetched?.invoke(updateKeys)
                    }
                }
                override fun onError(error : FirebaseRemoteConfigException) {
                    Log.e(TAG, "update error with code: " + error.code, error)
                }
            })
        }
    }

    suspend fun fetch(): Boolean {
        instance.fetchAndActivate().await().let { isSuccessFetch ->
            return isSuccessFetch
        }
    }


    companion object {

        private const val TAG = "RemoteConfig"
    }

}

@Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
inline fun <reified T> RemoteConfig.getConfig(key: String): T? {
    Firebase.remoteConfig.apply {
        return when(typeOf<T>().classifier) {
            Boolean::class -> getBoolean(key)
            Double::class  -> getDouble(key)
            Long::class    -> getLong(key)
            String::class  -> getString(key)
            else -> null
        } as T
    }
}
