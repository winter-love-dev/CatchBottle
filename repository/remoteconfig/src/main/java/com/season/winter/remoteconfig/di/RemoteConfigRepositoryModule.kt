package com.season.winter.remoteconfig.di

import com.season.winter.remoteconfig.RemoteConfigManager
import com.season.winter.remoteconfig.remote.RemoteConfigDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteConfigRepositoryModule {


    @Provides
    @Singleton
    fun provideRemoteConfig(
        remoteConfigManager: RemoteConfigManager
    ): RemoteConfigDao {
        return RemoteConfigDao(remoteConfigManager)
    }

}