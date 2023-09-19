package com.season.winter.common.dummy

import com.season.winter.common.di.database.CachedImageRepository
import com.season.winter.common.local.database.image.ImageDatabaseRoomDao
import com.season.winter.common.repository.CachedImageRepositoryImpl
import com.season.winter.storage.impl.FirebaseStorageImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DummyLiquorInfoRepositoryModule {

    @Singleton
    @Provides
    fun provideImageDatabaseRepository(
        imageDatabaseRepository: CachedImageRepository,
    ): DummyLiquorInfoRepository {
        return DummyLiquorInfoRepositoryImpl(imageDatabaseRepository)
    }
}