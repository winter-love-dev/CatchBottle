package com.season.winter.remoteconfig.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.season.winter.remoteconfig.local.database.RemoteConfigConverters
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteConfigRoomDao {

    @Query("SELECT * FROM remote_config_banner ORDER BY config_id")
    fun getBannerAll(): Flow<List<BannerData>>

    // 일괄 추가 or 업데이트
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBannerAll(bannerList: List<BannerData>)

//    @Insert(entity = BannerData::class, onConflict = OnConflictStrategy.REPLACE)
//    suspend fun updateBannerAll(jsonString: String)

//    @Delete
//    suspend fun deleteBannerAll()

}
