package com.season.winter.remoteconfig.di

import com.season.winter.remoteconfig.RemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteConfigModule {

    @Provides
    @Singleton
    fun provideRemoteConfigImpl(
        remoteConfig: RemoteConfig
    ): RemoteConfigService {
        return RemoteConfigServiceImpl(remoteConfig)
    }


    @Provides
    @Singleton
    fun provideRemoteConfig(): RemoteConfig {
        return RemoteConfig()
    }
}