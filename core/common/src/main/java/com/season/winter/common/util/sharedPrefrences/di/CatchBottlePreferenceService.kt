package com.season.winter.common.util.sharedPrefrences.di


interface CatchBottlePreferenceService {

//    fun create(context: Context, name: String): Rsa2048Preferences

    fun contains(key: String): Boolean
    fun clear()

    fun printName(key: String)

    fun get(key: String, defaultValue: Boolean): Boolean
    fun get(key: String, defaultValue: Int): Int
    fun get(key: String, defaultValue: Long): Long
    fun get(key: String, defaultValue: String): String

    fun put(key: String, value: Boolean)
    fun put(key: String, value: Int)
    fun put(key: String, value: Long)
    fun put(key: String, value: String)

    fun <T : Any> getInternal(key: String, defaultValue: T): T
    fun putInternal(key: String, value: Any?)

}