package com.season.winter.common.di.sharedPreferences.appConfig

import com.season.winter.common.local.sharedPreferences.AppConfigDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppConfigRepositoryModule {

    @Provides
    @Singleton
    fun provideDummyRepository(dao: AppConfigDao): AppConfigRepositoryImpl {
        return AppConfigRepositoryImpl(dao)
    }
}