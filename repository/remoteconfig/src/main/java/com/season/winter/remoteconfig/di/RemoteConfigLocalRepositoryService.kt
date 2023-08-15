package com.season.winter.remoteconfig.di

import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

interface RemoteConfigLocalRepositoryService {
    val bannerFlow: Flow<List<BannerData>>
}