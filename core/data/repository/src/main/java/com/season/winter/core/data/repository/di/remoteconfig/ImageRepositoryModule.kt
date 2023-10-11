package com.season.winter.core.data.repository.di.remoteconfig

import android.content.Context
import com.season.winter.core.data.repository.CachedImageRepositoryImpl
import com.season.winter.core.data.repository.FirebaseStorageRepositoryImpl
import com.season.winter.core.data.repository.database.ImageRoomDatabase
import com.season.winter.core.domain.repository.CachedImageRepository
import com.season.winter.storage.ImageFireStorageDao
import com.season.winter.core.domain.database.ImageDatabaseRoomDao
import com.season.winter.core.domain.repository.FirebaseStorageRepository
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
        imageFireStorage: ImageFireStorageDao
    ): FirebaseStorageRepository {
        return FirebaseStorageRepositoryImpl(imageFireStorage)
    }

    @Singleton
    @Provides
    fun provideImageDatabaseRepository(
        imageFireStorage: FirebaseStorageRepositoryImpl,
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