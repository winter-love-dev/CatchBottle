package com.season.winter.common.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.season.winter.common.ImageNameUrlPairEntity

@Dao
interface ImageDatabaseFetcherDao {

    // OnConflictStrategy.REPLACE: 중복 primary 값을 덮어 씌우기
    @Query("SELECT * FROM image_name_url_pair_entity WHERE file_name = :fileName LIMIT 1")
    suspend fun checkForSearchImageData(fileName: String): ImageNameUrlPairEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageDataList(fileName: List<ImageNameUrlPairEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageData(fileName: ImageNameUrlPairEntity)

    @Query("DELETE FROM image_name_url_pair_entity")
    fun clear()
}