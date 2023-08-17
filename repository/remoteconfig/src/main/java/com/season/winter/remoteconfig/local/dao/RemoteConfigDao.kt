package com.season.winter.remoteconfig.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteConfigDao {

    @Query("SELECT * FROM remote_config_banner ORDER BY config_id")
    fun getBannerAll(): Flow<List<BannerData>>

}
