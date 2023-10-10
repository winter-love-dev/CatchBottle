package com.season.winter.core.data.repository.di.storage

import com.season.winter.core.data.repository.FirebaseStorageRepositoryImpl
import com.season.winter.core.domain.repository.FirebaseStorageRepository
import com.season.winter.storage.ImageFireStorageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseStorageModule {

    @Singleton
    @Provides
    fun provideFirebaseStorageImpl(
        imageFireStorage: ImageFireStorageDao
    ): FirebaseStorageRepository {
        return FirebaseStorageRepositoryImpl(
            imageFireStorage
        )
    }

    @Singleton
    @Provides
    fun provideImageFireStorageDao(): ImageFireStorageDao {
        return ImageFireStorageDao()
    }



}