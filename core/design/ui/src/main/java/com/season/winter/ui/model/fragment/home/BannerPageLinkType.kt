package com.season.winter.ui.model.fragment.home

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Entity
@Serializable
enum class BannerPageLinkType(

    @ColumnInfo(name = "page_type", defaultValue = "1")
    @SerialName("pageType")
    val identify: Int
) {
    @SerialName("0") Web(0),
    @SerialName("1") InApp(1),
    ;

    companion object {
        fun toType(identify: Int): BannerPageLinkType? {
            return when(identify) {
                0 -> Web
                1 -> InApp
                else -> null
            }
        }
    }
}