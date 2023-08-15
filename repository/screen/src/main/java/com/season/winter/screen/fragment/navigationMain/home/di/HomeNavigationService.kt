package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.ui.model.fragment.home.HomeItem
import kotlinx.coroutines.flow.Flow

interface HomeNavigationService {
    val mainListFlow: Flow<List<HomeItem>>
}
