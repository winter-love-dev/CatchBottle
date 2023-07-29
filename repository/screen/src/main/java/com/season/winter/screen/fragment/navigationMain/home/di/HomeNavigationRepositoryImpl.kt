package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.screen.fragment.navigationMain.home.local.HomeNavigationDummyDao
import com.season.winter.ui.model.fragment.home.HomeItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeNavigationRepositoryModule {

    @Provides
    @Singleton
    fun provideDummyRepository(dao: HomeNavigationDummyDao): HomeNavigationRepositoryImpl {
        return HomeNavigationRepositoryImpl(dao)
    }
}

class HomeNavigationRepositoryImpl @Inject constructor(
    private val dummyDao: HomeNavigationDummyDao
): HomeNavigationService {

    override fun getHomeUIDummyData(): List<HomeItem> {
        return dummyDao.mainList
    }
}
