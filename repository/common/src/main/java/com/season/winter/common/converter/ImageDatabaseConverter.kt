package com.season.winter.common.converter

import androidx.room.TypeConverter
import com.season.winter.ui.model.fragment.home.BannerPageLinkType

object ImageDatabaseConverter {

    @TypeConverter
    fun empty(int: Int): Int {
        return int
    }
}