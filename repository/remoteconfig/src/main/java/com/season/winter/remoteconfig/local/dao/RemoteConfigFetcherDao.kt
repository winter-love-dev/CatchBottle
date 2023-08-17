package com.season.winter.remoteconfig.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.season.winter.ui.model.fragment.home.BannerData

@Dao
interface RemoteConfigFetcherDao {

    // 일괄 추가 or 업데이트
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBannerAll(bannerList: List<BannerData>)

}
