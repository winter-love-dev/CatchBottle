package com.season.winter.remoteconfig.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteConfigDao {

    // 일괄 추가 or 업데이트
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBannerAll(bannerList: List<BannerData>)

    @Query("SELECT * FROM remote_config_banner ORDER BY config_id")
    fun getBannerAllFlow(): Flow<List<BannerData>>

    @Query("SELECT * FROM remote_config_banner ORDER BY config_id")
    suspend fun getBannerAll(): List<BannerData>

}
