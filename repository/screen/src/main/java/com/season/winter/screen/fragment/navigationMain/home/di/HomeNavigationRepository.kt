package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.liquor.dummy.model.HomeItem
import kotlinx.coroutines.flow.Flow

interface HomeNavigationRepository {
    val mainListFlow: Flow<List<HomeItem>>

    fun getMainListFlow()
}
