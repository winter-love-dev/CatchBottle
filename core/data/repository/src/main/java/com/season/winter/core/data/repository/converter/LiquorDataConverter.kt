package com.season.winter.core.data.repository.converter

import androidx.room.TypeConverter
import com.season.winter.liquor.content.FeatureType

class LiquorDataConverter {

    @TypeConverter
    fun bannerPageLinkTypeToInt(pageType: FeatureType): Int {
        return pageType.identify
    }

    @TypeConverter
    fun intToFeatureType(type: Int): FeatureType {
        return FeatureType.toType(type) ?: FeatureType.Text
    }
}