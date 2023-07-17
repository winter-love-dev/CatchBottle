package com.season.winter.common.util.sharedPrefrences

import android.content.Context
import android.content.SharedPreferences
import com.season.winter.config.sharedPrefences.base.PrefCommon

/**
 * A [android.content.SharedPreferences] wrapper that helps easy reading/writing values. 쉽게 읽기/쓰기 값을 도움이 되는 래퍼입니다.
 * securePref
 * val prefHelper = TokenBankApplication.prefHelper
 */
class SecureSharedPreferences(private val sharedPref: SharedPreferences) {

    // 이미 사용중인 설정값인지 조회하기
    fun contains(key: String) = sharedPref.contains(key)

    /** 읽기! */
    fun get(key: String, defaultValue: Boolean): Boolean = getInternal(key, defaultValue)

    fun get(key: String, defaultValue: Int): Int = getInternal(key, defaultValue)

    fun get(key: String, defaultValue: Long): Long = getInternal(key, defaultValue)

    fun get(key: String, defaultValue: String): String = getInternal(key, defaultValue)

    /** 클라이언트 코드는 발생하는 경우 호출 사이트에서 클래스 캐스트 예외를 자체적으로 처리해야 합니다. */
    private fun <T : Any> getInternal(key: String, defaultValue: T): T {

        val str = sharedPref.getString(key, "")
        if (str.isNullOrEmpty()) {
            return defaultValue
        }
        val value = AndroidRsaCipherHelper.decrypt(str)

        // @억제(인라인의 플랫폼 확장 수신기, 확인되지 않은 캐스트, 임의로 암시적 캐스트)
        @Suppress("PlatformExtensionReceiverOfInline", "UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
        return when(defaultValue) {
            is Boolean -> value.toBoolean()
            is Int     -> value.toInt()
            is Long    -> value.toLong()
            is String  -> value

            // 기본 값은 부울, Int, 롱, 스트링 중 하나일 뿐입니다.
            else -> throw IllegalArgumentException("defaultValue only could be one of these types: Boolean, Int, Long, String")
        } as T
    }



    // ---------------------------
    /** 쓰기! */
    fun put(key: String, value: Boolean) = putInternal(key, value)

    fun put(key: String, value: Int) = putInternal(key, value)

    fun put(key: String, value: Long) = putInternal(key, value)

    /** 암호화 계층 제한으로 인해 입력 값이 [암호 도우미.KEY 길이 BIT] 바이트보다 짧아야 합니다. */
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
            _instance = SecureSharedPreferences(prefHelper)
        }

        val securePreferences: SecureSharedPreferences
            get() = instance
    }
}