package com.season.winter.core.data.repository.di

import com.season.winter.core.data.repository.converter.LiquorDataConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LiquorRepositoryModule {

    @Provides
    @Singleton
    fun provideLiquorDataConverter(
        remoteConfigManager: LiquorDataConverter
    ): LiquorDataConverter {
        return remoteConfigManager
    }
}