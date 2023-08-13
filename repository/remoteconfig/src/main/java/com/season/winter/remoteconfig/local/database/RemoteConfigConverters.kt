package com.season.winter.remoteconfig.local.database

import androidx.room.TypeConverter
import com.season.winter.common.extention.primitive.decodeFromJsonStringSafety
import com.season.winter.ui.model.fragment.home.BannerData
import com.season.winter.ui.model.fragment.home.BannerPageLinkType


object RemoteConfigConverters {

    @TypeConverter
    fun bannerPageLinkTypeToInt(pageType: BannerPageLinkType): Int {
        return pageType.identify
    }

    @TypeConverter
    fun intToFeatureType(pageType: Int): BannerPageLinkType {
        return BannerPageLinkType.toType(pageType) ?: BannerPageLinkType.InApp
    }

    @TypeConverter
    fun jsonStringToBannerList(bannerJsonString: String): List<BannerData>? {
        return bannerJsonString
            .decodeFromJsonStringSafety<List<BannerData>>()
    }


//    @TypeConverter
//    @JvmStatic
//    fun fromUserPlaceType(value: UserPlaceType?) = value?.name
//
//    @TypeConverter
//    @JvmStatic
//    fun toUserPlaceType(value: String?) = UserPlaceType.values.firstOrNull { it.name == value }


//    @TypeConverter
//    fun intToFeatureType(pageType: Int): BannerPageLinkType {
//        return BannerPageLinkType.toType(pageType) ?: BannerPageLinkType.InApp
//    }

}