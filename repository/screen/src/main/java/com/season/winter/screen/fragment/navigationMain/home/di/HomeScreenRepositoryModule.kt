package com.season.winter.screen.fragment.navigationMain.home.di

import com.season.winter.common.dummy.DummyLiquorInfoRepository
import com.season.winter.remoteconfig.local.dao.RemoteConfigDao
import com.season.winter.screen.fragment.navigationMain.home.domain.GetHomeScreenDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeScreenRepositoryModule {

    @Provides
    @Singleton
    fun provideHomeScreenDataUseCase(
        dummyLiquorInfoRepository: DummyLiquorInfoRepository,
        remoteConfigDao: RemoteConfigDao
    ): GetHomeScreenDataUseCase {

        return GetHomeScreenDataUseCase(
            dummyLiquorInfoRepository,
            remoteConfigDao
        )
    }

}