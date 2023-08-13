package com.season.winter.remoteconfig

import com.season.winter.remoteconfig.local.dao.RemoteConfigLocalDao
import com.season.winter.remoteconfig.remote.dao.RemoteConfigDao
import com.season.winter.remoteconfig.remote.di.RemoteConfigService
import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RemoteConfigRepositoryImpl @Inject constructor(
    private val remoteDao: RemoteConfigDao,
    private val remoteConfigLocalDao: RemoteConfigLocalDao,
): RemoteConfigService {

    private val coroutineScope = CoroutineScope(SupervisorJob())

    override val onBannerConfigDataFlow: SharedFlow<List<BannerData>>
        get() = remoteDao.onBannerConfigDataFlow

    init {
        coroutineScope.launch {
            remoteDao.onBannerConfigDataFlow.collect {

            }
        }
    }

    override fun getBanner() {
        remoteConfigLocalDao.getBannerAll()
    }

    override fun refreshConfig() {
        remoteDao.refreshConfig()
    }
}