package com.season.winter.remoteconfig.di

import com.season.winter.ui.model.fragment.home.BannerData
import kotlinx.coroutines.flow.SharedFlow

interface RemoteConfigService {

    val onBannerConfigDataFlow: SharedFlow<List<BannerData>>

    fun refreshConfig()
}