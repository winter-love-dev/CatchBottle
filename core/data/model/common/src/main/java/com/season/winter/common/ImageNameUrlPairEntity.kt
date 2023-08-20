package com.season.winter.common

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_name_url_pair_entity")
data class ImageNameUrlPairEntity(

    @PrimaryKey
    @ColumnInfo(name = "file_name")
    var fileName: String,

    @ColumnInfo(name = "url")
    val url: String? = null,
)
