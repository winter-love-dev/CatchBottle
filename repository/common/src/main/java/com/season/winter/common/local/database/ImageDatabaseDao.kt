package com.season.winter.common.local.database

import androidx.room.Dao
import androidx.room.Query
import com.season.winter.common.ImageNameUrlPairEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDatabaseDao {

    @Query("SELECT * FROM image_name_url_pair_entity WHERE file_name = :fileName LIMIT 1")
    fun getImageData(fileName: String): Flow<List<ImageNameUrlPairEntity>>?

}