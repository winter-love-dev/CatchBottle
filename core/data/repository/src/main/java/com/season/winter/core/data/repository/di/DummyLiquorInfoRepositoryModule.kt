package com.season.winter.core.data.repository.di

import com.season.winter.core.domain.repository.DummyLiquorInfoRepository
import com.season.winter.core.data.repository.dummy.DummyLiquorInfoRepositoryImpl
import com.season.winter.core.domain.repository.CachedImageRepository
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