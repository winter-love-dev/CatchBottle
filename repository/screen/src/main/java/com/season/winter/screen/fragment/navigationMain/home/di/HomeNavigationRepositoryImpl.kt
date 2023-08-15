package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.screen.fragment.navigationMain.home.local.HomeNavigationDummyDao
import com.season.winter.ui.model.fragment.home.HomeItem
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class HomeNavigationRepositoryImpl @Inject constructor(
    private val dummyDao: HomeNavigationDummyDao
): HomeNavigationService {

    override val mainListFlow = dummyDao.mainListFlow

}
