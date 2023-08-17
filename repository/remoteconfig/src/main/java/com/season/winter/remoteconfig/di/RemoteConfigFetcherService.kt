package com.season.winter.remoteconfig.di

interface RemoteConfigFetcherService {
    suspend fun saveBannerData(key: String)
    suspend fun fetch()
}