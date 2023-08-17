package com.season.winter.ui.model.fragment.home

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(
    tableName = "remote_config_banner",
    indices = [Index("config_id")],
//    foreignKeys = [
//        ForeignKey(
//            entity = FeatureData::class,
//            parentColumns = ["id"],
//            childColumns = ["config_id"]
//        )
//    ],
)
data class BannerData(

    @ColumnInfo(name = "image_file_name")
    val imageFileName: String,

    @ColumnInfo(name = "image_url")
    var imageUrl: String? = null,

    @ColumnInfo(name = "web_page_url")
    var webPageUrl: String? = null,


    // room에서 enum 다룰 방안 마련 필요
//    @ColumnInfo(name = "page_type")
//    var pageType: BannerPageLinkType? = null,
//
//    @ColumnInfo(name = "feature")
//    var feature: FeatureData? = null,
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "config_id")
    var sortId: Long = 0
}