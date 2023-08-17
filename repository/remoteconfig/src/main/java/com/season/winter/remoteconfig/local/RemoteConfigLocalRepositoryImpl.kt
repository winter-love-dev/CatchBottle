package com.season.winter.remoteconfig.local

import com.season.winter.remoteconfig.di.RemoteConfigLocalRepositoryService
import com.season.winter.remoteconfig.local.dao.RemoteConfigDao
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 저장된 데이터만 조회하는 Repository
 */
class RemoteConfigLocalRepositoryImpl @Inject constructor(
    private val localDao: RemoteConfigDao,
): RemoteConfigLocalRepositoryService {

    override val bannerFlow: Flow<List<BannerData>> = localDao.getBannerAll()

    companion object {

        private const val TAG = "RemoteConfigRepositoryImpl"
    }
}