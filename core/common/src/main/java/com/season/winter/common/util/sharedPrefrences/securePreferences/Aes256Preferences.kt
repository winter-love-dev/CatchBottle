package com.season.winter.common.util.sharedPrefrences.securePreferences

import android.content.Context
import android.content.SharedPreferences
import com.season.winter.common.util.sharedPrefrences.factory.SharedPreferencesService

class Aes256Preferences(private val sharedPref: SharedPreferences): SharedPreferencesService {

    override fun contains(key: String): Boolean {
        return sharedPref.contains(key)
    }

    override fun clear() {
        sharedPref.edit().run {
            clear()
            apply()
        }
    }

    override fun get(key: String, defaultValue: Boolean): Boolean = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: Int): Int = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: Long): Long = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: String): String = getInternal(key, defaultValue)

    private fun <T : Any> getInternal(key: String, defaultValue: T): T {

        val str = sharedPref.getString(key, "")
        if (str.isNullOrEmpty()) {
            return defaultValue
        }


        val value = AndroidRsaCipherHelper.decrypt(str)

        @Suppress("PlatformExtensionReceiverOfInline", "UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
        return when(defaultValue) {
            is Boolean -> value.toBoolean()
            is Int     -> value.toInt()
            is Long    -> value.toLong()
            is String  -> value

            else -> throw IllegalArgumentException("defaultValue only could be one of these types: Boolean, Int, Long, String")
        } as T
    }


    override fun put(key: String, value: Boolean) = putInternal(key, value)
    override fun put(key: String, value: Int) = putInternal(key, value)
    override fun put(key: String, value: Long) = putInternal(key, value)
    override fun put(key: String, value: String) = putInternal(key, value)

    private fun putInternal(key: String, value: Any?) {
        try {
            sharedPref.edit().run {
                if (value == null) {
                    remove(key)
                } else {
                    putString(key, AndroidRsaCipherHelper.encrypt(value.toString()))
                }
                apply()
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    companion object {

        const val PrefCommon = "PrefCommon"

        lateinit var securePreferences: Aes256Preferences
            private set

        fun init(context: Context) {
            if (Companion::securePreferences.isInitialized.not()) {
                val prefHelper = context.getSharedPreferences(PrefCommon, 0)
                securePreferences = Aes256Preferences(prefHelper)
            }
        }

        fun createRsa2048(context: Context, name: String): Aes256Preferences {
            val prefHelper = context.getSharedPreferences(name, 0)
            return Aes256Preferences(prefHelper)
        }
    }
}