package com.season.winter.core.domain.repository

import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.Flow

interface RemoteConfigLocalRepository {
    val bannerFlow: Flow<List<BannerData>>
}