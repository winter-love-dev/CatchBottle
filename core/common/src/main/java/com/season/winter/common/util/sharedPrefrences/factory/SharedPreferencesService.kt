package com.season.winter.common.util.sharedPrefrences.factory

interface SharedPreferencesService {

    fun contains(key: String): Boolean
    fun clear()

    fun get(key: String, defaultValue: Boolean): Boolean
    fun get(key: String, defaultValue: Int): Int
    fun get(key: String, defaultValue: Long): Long
    fun get(key: String, defaultValue: String): String

    fun put(key: String, value: Boolean)
    fun put(key: String, value: Int)
    fun put(key: String, value: Long)
    fun put(key: String, value: String)

}