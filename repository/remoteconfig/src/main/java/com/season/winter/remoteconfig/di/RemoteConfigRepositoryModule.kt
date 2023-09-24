package com.season.winter.remoteconfig.di

import android.content.Context
import com.season.winter.remoteconfig.local.dao.RemoteConfigDao
import com.season.winter.remoteconfig.local.database.RemoteConfigDatabase
import com.season.winter.remoteconfig.domain.RemoteConfigFetcherUseCase
import com.season.winter.storage.ImageFireStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteConfigRepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteConfigFetcherRepository(
        remoteConfigImpl: RemoteConfigServiceImpl,
        remoteConfigFetcherDao: RemoteConfigDao,
        imageFireStorage: ImageFireStorage
    ): RemoteConfigFetcherUseCase {

        return RemoteConfigFetcherUseCase(
            remoteConfigImpl,
            remoteConfigFetcherDao,
            imageFireStorage
        )
    }

    @Singleton
    @Provides
    fun provideRemoteConfigDatabase(
        @ApplicationContext context: Context
    ): RemoteConfigDatabase {
        return RemoteConfigDatabase.getInstance(context)
    }

    @Provides
    fun provideRemoteConfigDao(appDatabase: RemoteConfigDatabase): RemoteConfigDao {
        return appDatabase.remoteConfigDao()
    }

}