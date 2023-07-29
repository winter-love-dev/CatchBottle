package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.screen.fragment.navigationMain.home.local.HomeNavigationDummyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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