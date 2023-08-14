package com.season.winter.remoteconfig.di

interface RemoteConfigRepositoryService {
    suspend fun saveBannerData(key: String)
    suspend fun fetch()
}