package com.season.winter.common.util.sharedPrefrences

import android.content.Context
import android.content.SharedPreferences
import com.season.winter.config.sharedPrefences.base.PrefCommon

class SecureSharedPreferences(private val sharedPref: SharedPreferences) {

    // 사용중인 키 값인지 확인하기
    fun contains(key: String) = sharedPref.contains(key)

    fun get(key: String, defaultValue: Boolean): Boolean = getInternal(key, defaultValue)
    fun get(key: String, defaultValue: Int): Int = getInternal(key, defaultValue)
    fun get(key: String, defaultValue: Long): Long = getInternal(key, defaultValue)
    fun get(key: String, defaultValue: String): String = getInternal(key, defaultValue)

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


    fun put(key: String, value: Boolean) = putInternal(key, value)
    fun put(key: String, value: Int) = putInternal(key, value)
    fun put(key: String, value: Long) = putInternal(key, value)
    fun put(key: String, value: String) = putInternal(key, value)

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

        private lateinit var prefHelper: SharedPreferences

        private var _instance: SecureSharedPreferences? = null
        private val instance: SecureSharedPreferences
            get() = _instance!!

        fun init(context: Context) {
            prefHelper = context.getSharedPreferences(PrefCommon, 0)
            if (_instance == null)
                _instance = SecureSharedPreferences(prefHelper)
        }

        val securePreferences: SecureSharedPreferences
            get() = instance

        fun Context.clearAllPreferences() {
            getSharedPreferences(PrefCommon, 0)
                .edit()
                .run {
                    clear()
                    commit()
                }
            init(this)
        }
    }
}