package com.season.winter.common.di.database

import android.content.Context
import com.season.winter.common.local.database.image.ImageDatabase
import com.season.winter.common.local.database.image.ImageDatabaseDao
import com.season.winter.common.local.database.image.ImageDatabaseFetcherDao
import com.season.winter.common.repository.ImageDatabaseRepositoryFetcherImpl
import com.season.winter.common.repository.ImageDatabaseRepositoryImpl
import com.season.winter.storage.impl.FirebaseStorageImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageRepositoryModule {

    @Singleton
    @Provides
    fun provideImageDatabaseRepository(
        imageFireStorage: FirebaseStorageImpl,
        imageDao: ImageDatabaseDao
    ): ImageDatabaseRepositoryImpl {
        return ImageDatabaseRepositoryImpl(imageFireStorage, imageDao)
    }

    @Singleton
    @Provides
    fun provideImageDatabaseFetcherRepository(
        fetcherDao: ImageDatabaseFetcherDao
    ): ImageDatabaseRepositoryFetcherImpl {
        return ImageDatabaseRepositoryFetcherImpl(fetcherDao)
    }

    @Singleton
    @Provides
    fun provideImageDatabase(
        @ApplicationContext context: Context
    ): ImageDatabase {
        return ImageDatabase.getInstance(context)
    }

    @Provides
    fun provideImageDatabaseDao(database: ImageDatabase): ImageDatabaseDao {
        return database.imageDataDao()
    }

    @Provides
    fun provideImageDatabaseFetcherDao(database: ImageDatabase): ImageDatabaseFetcherDao {
        return database.imageDataFetcherDao()
    }
}