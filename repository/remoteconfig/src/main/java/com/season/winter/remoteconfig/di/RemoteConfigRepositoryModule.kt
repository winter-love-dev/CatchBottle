package com.season.winter.remoteconfig.di

import android.content.Context
import com.season.winter.remoteconfig.local.RemoteConfigLocalRepositoryImpl
import com.season.winter.remoteconfig.local.dao.RemoteConfigDao
import com.season.winter.remoteconfig.local.dao.RemoteConfigFetcherDao
import com.season.winter.remoteconfig.local.database.RemoteConfigDatabase
import com.season.winter.remoteconfig.remote.RemoteConfigFetcherRepository
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
    fun provideRemoteConfigLocalRepositoryImpl(
        remoteConfigLocalDao: RemoteConfigDao,
    ): RemoteConfigLocalRepositoryImpl {

        return RemoteConfigLocalRepositoryImpl(
            remoteConfigLocalDao
        )
    }

    @Provides
    @Singleton
    fun provideRemoteConfigFetcherRepository(
        remoteConfigImpl: RemoteConfigImpl,
        remoteConfigFetcherDao: RemoteConfigFetcherDao,
    ): RemoteConfigFetcherRepository {

        return RemoteConfigFetcherRepository(
            remoteConfigImpl,
            remoteConfigFetcherDao
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

    @Provides
    fun provideRemoteConfigFetcherDao(appDatabase: RemoteConfigDatabase): RemoteConfigFetcherDao {
        return appDatabase.remoteConfigFetcherDao()
    }

}