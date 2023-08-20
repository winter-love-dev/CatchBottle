package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.screen.fragment.navigationMain.home.local.HomeNavigationDummyDao
import javax.inject.Inject

class HomeNavigationRepositoryImpl @Inject constructor(
    private val dummyDao: HomeNavigationDummyDao
): HomeNavigationService {

    override val mainListFlow = dummyDao.mainListFlow
    override fun getMainListFlow() {
        dummyDao.getMainList()
    }
}
