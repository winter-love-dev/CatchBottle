package com.season.winter.common.util.sharedPrefrences.securePreferences

import android.content.Context
import android.util.Log
import com.season.winter.common.util.sharedPrefrences.di.CatchBottlePreferenceService
import javax.inject.Inject


class Rsa2048PreferencesDao @Inject constructor(
    context: Context,
    private val name: String,
    private val cipherHelper: Rsa2048CipherHelper,
): CatchBottlePreferenceService {

    private val sharedPref =
        context.getSharedPreferences(name, 0)

    override fun contains(key: String): Boolean {
        return sharedPref.contains(key)
    }

    override fun clear() {
        printName("clear()")
        sharedPref.edit().run {
            clear()
            apply()
        }
    }

    override fun printName(key: String) {
        Log.e(TAG, "$key is $name", )
    }

    override fun get(key: String, defaultValue: Boolean): Boolean = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: Int): Int = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: Long): Long = getInternal(key, defaultValue)
    override fun get(key: String, defaultValue: String): String = getInternal(key, defaultValue)

    override fun <T : Any> getInternal(key: String, defaultValue: T): T {

        printName("get key: $key")

        val str = sharedPref.getString(key, "")
        if (str.isNullOrEmpty()) {
            return defaultValue
        }


        val value = cipherHelper.decrypt(str)

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

    override fun putInternal(key: String, value: Any?) {

        printName("put key: $key")

        try {
            sharedPref.edit().run {
                if (value == null) {
                    remove(key)
                } else {
                    putString(key, cipherHelper.encrypt(value.toString()))
                }
                apply()
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    companion object {

        const val TAG = "Rsa2048Preferences"
    }
}