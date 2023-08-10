package com.season.winter.remoteconfig.di

import com.season.winter.remoteconfig.remote.RemoteConfigDao
import javax.inject.Inject

class RemoteConfigRepositoryImpl @Inject constructor(
    private val remoteDao: RemoteConfigDao
): RemoteConfigService {

    override fun refreshConfig() {
        remoteDao.refreshConfig()
    }
}