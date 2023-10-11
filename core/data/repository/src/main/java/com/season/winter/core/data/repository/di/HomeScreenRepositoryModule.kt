package com.season.winter.core.data.repository.di

import com.season.winter.core.domain.database.RemoteConfigDao
import com.season.winter.core.domain.repository.DummyLiquorInfoRepository
import com.season.winter.core.domain.usecase.GetHomeScreenDataUseCase
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