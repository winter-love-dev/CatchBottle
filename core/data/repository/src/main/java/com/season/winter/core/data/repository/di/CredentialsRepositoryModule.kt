package com.season.winter.core.data.repository.di

import com.season.winter.core.data.repository.CredentialsDummyRepositoryImpl
import com.season.winter.core.data.repository.CredentialsImpl
import com.season.winter.core.domain.repository.CredentialsRepository
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
    fun provideCredentialsRepository(dao: CredentialsDummyRepositoryImpl): CredentialsRepository {
        return CredentialsImpl(dao)
    }
}