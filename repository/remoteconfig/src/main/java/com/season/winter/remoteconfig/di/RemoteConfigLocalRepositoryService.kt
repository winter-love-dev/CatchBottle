package com.season.winter.remoteconfig.di

import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

interface RemoteConfigLocalRepositoryService {
    fun getBanner(): Flow<List<BannerData>>
}