package com.season.winter.remoteconfig

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ConfigUpdate
import com.google.firebase.remoteconfig.ConfigUpdateListener
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.season.winter.common.constants.TimeVariable
import com.season.winter.remoteconfig.di.RemoteConfigKey.KeyAll
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.reflect.typeOf

class RemoteConfig @Inject constructor() {

    var announceFetched: ((keys: List<String>) -> Unit)? = null

    private val configSettings = remoteConfigSettings {
        minimumFetchIntervalInSeconds = TimeVariable.Zero.value
    }

    // setOnLiveConfigUpdateListener
    private val instance = Firebase.remoteConfig.also {
        it.setConfigSettingsAsync(configSettings)
        it.setDefaultsAsync(R.xml.remote_config_defaults)
        it.addOnConfigUpdateListener(object: ConfigUpdateListener {
            override fun onUpdate(configUpdate: ConfigUpdate) {
                val updateKeys = mutableListOf<String>()

                KeyAll.forEach { key ->
                    if (configUpdate.updatedKeys.contains(key))
                        updateKeys.add(key)
                }

                if (updateKeys.isNotEmpty())
                    announceFetched?.invoke(updateKeys)
            }

            override fun onError(error : FirebaseRemoteConfigException) {
                Log.e(TAG, "update error with code: " + error.code, error)
            }
        })
    }

    suspend fun fetch(): Boolean {
        val isSuccessFetch = instance.fetchAndActivate()
            .addOnFailureListener { result ->
                // FirebaseRemoteConfigClientException: The client had an error while calling the backend!
                // UnknownHostException: Unable to resolve host "firebaseremoteconfig.googleapis.com": No address associated with hostname
                Log.e(TAG, "fetch: addOnFailureListener: $result")
            }
            .await()

        return isSuccessFetch
    }


    companion object {

        private const val TAG = "RemoteConfig"
    }

}

/** generic 'inline, reified, in, out' 키워드 다시 공부하기  */
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
