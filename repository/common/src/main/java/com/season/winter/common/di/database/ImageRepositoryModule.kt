package com.season.winter.common.di.database

import android.content.Context
import com.season.winter.common.local.database.image.ImageRoomDatabase
import com.season.winter.common.local.database.image.ImageDatabaseRoomDao
import com.season.winter.common.repository.CachedImageRepositoryImpl
import com.season.winter.storage.ImageFireStorage
import com.season.winter.storage.impl.FirebaseStorageImpl
import com.season.winter.storage.impl.FirebaseStorageRepository
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
    fun provideFirebaseStorage(
        imageFireStorage: ImageFireStorage
    ): FirebaseStorageRepository {
        return FirebaseStorageImpl(imageFireStorage)
    }

    @Singleton
    @Provides
    fun provideImageDatabaseRepository(
        imageFireStorage: FirebaseStorageImpl,
        imageDao: ImageDatabaseRoomDao
    ): CachedImageRepository {
        return CachedImageRepositoryImpl(imageFireStorage, imageDao)
    }

    @Singleton
    @Provides
    fun provideImageDatabase(
        @ApplicationContext context: Context
    ): ImageRoomDatabase {
        return ImageRoomDatabase.getInstance(context)
    }

    @Provides
    fun provideImageDatabaseDao(database: ImageRoomDatabase): ImageDatabaseRoomDao {
        return database.imageDataDao()
    }
}