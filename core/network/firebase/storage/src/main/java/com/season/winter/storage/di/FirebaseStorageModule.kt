package com.season.winter.storage.di

import com.season.winter.storage.ImageFireStorage
import com.season.winter.storage.impl.FirebaseStorageImpl
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
        imageFireStorage: ImageFireStorage
    ): FirebaseStorageImpl {
        return FirebaseStorageImpl(imageFireStorage)
    }

    @Singleton
    @Provides
    fun provideImageFireStorage(): ImageFireStorage {
        return ImageFireStorage()
    }



}