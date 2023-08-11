package com.season.winter.remoteconfig.di

import com.season.winter.remoteconfig.remote.RemoteConfigDao
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class RemoteConfigRepositoryImpl @Inject constructor(
    private val remoteDao: RemoteConfigDao
): RemoteConfigService {

    override val onBannerConfigDataFlow: SharedFlow<List<BannerData>>
        get() = remoteDao.onSomeOtherConfig

    override fun refreshConfig() {
        remoteDao.refreshConfig()
    }
}