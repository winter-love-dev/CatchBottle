package com.season.winter.user.di

import com.season.winter.user.local.CBCredentialsDummyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CredentialsRepositoryModule {

    @Provides
    @Singleton
    fun provideCredentialsRepository(dao: CBCredentialsDummyDao): Credentials {
        return Credentials(dao)
    }
}