package com.season.winter.remoteconfig.di

import android.content.Context
import androidx.work.WorkManager
import com.season.winter.remoteconfig.RemoteConfigRepositoryImpl
import com.season.winter.remoteconfig.local.dao.RemoteConfigRoomDao
import com.season.winter.remoteconfig.local.database.RemoteConfigDatabase
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
    fun provideRemoteConfigRepository(
        remoteConfigImpl: RemoteConfigImpl,
        remoteConfigLocalDao: RemoteConfigRoomDao,
    ): RemoteConfigRepositoryImpl {

        return RemoteConfigRepositoryImpl(
            remoteConfigImpl,
            remoteConfigLocalDao
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
    fun providePlantDao(appDatabase: RemoteConfigDatabase): RemoteConfigRoomDao {
        return appDatabase.remoteConfigDao()
    }


}