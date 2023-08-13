package com.season.winter.remoteconfig.local.di

import android.content.Context
import com.season.winter.remoteconfig.local.dao.RemoteConfigLocalDao
import com.season.winter.remoteconfig.local.database.RemoteConfigDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteConfigDatabaseModule {

    @Singleton
    @Provides
    fun provideRemoteConfigDatabase(@ApplicationContext context: Context): RemoteConfigDatabase {
        return RemoteConfigDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(appDatabase: RemoteConfigDatabase): RemoteConfigLocalDao {
        return appDatabase.remoteConfigDao()
    }

}