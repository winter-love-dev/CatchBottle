package com.season.winter.core.data.repository.converter

import androidx.room.TypeConverter

object ImageDatabaseConverter {

    @TypeConverter
    fun empty(int: Int): Int {
        return int
    }
}