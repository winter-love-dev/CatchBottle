package com.season.winter.core.data.repository.di.remoteconfig

import android.content.Context
import com.season.winter.core.data.repository.RemoteConfigServiceImpl
import com.season.winter.core.data.repository.database.RemoteConfigDatabase
import com.season.winter.core.domain.database.RemoteConfigDao
import com.season.winter.core.domain.usecase.RemoteConfigFetcherUseCase
import com.season.winter.storage.ImageFireStorageDao
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
        imageFireStorage: ImageFireStorageDao
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