package com.season.winter.liquor.dummy.database.converter

import androidx.room.TypeConverter
import com.season.winter.liquor.content.FeatureType
import javax.inject.Inject

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