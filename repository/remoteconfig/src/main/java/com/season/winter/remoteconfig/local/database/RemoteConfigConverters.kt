package com.season.winter.remoteconfig.local.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.season.winter.ui.model.fragment.home.BannerPageLinkType


@ProvidedTypeConverter
object RemoteConfigConverters {

    @TypeConverter
    fun bannerPageLinkTypeToInt(pageType: BannerPageLinkType): Int {
        return pageType.identify
    }

    @TypeConverter
    fun intToFeatureType(pageType: Int): BannerPageLinkType {
        return BannerPageLinkType.toType(pageType) ?: BannerPageLinkType.InApp
    }

//    @TypeConverter
//    suspend fun jsonStringToBannerList(bannerJsonString: String = ""): List<BannerData>? {
//
//        return bannerJsonString
//            ?.decodeFromJsonStringSafety<List<BannerData>>()
//            ?.apply { loadBannerUrlFromFileName(this) }
//            ?: return null
//    }
//
//    private suspend fun loadBannerUrlFromFileName(list: List<BannerData>) {
//        list.forEach { banner ->
//            banner.imageFileName.let { imageFileName ->
//                val url = ImageFireStorageInstance.getImageUrlFromFileName(imageFileName)
//                banner.imageUrl = url
//            }
//        }
//    }

}