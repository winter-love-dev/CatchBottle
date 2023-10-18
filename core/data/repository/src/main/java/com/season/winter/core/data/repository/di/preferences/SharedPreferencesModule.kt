package com.season.winter.core.data.repository.di.preferences

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.cipher.Rsa2048CipherHelper
import com.season.winter.common.util.sharedPrefrences.CatchBottleSharedPreferences
import com.season.winter.core.data.repository.AppPreferencesRepositoryImpl
import com.season.winter.core.data.repository.CredentialsRepositoryImpl
import com.season.winter.core.domain.repository.AppPreferencesRepository
import com.season.winter.core.domain.repository.CredentialsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    private const val appConfigPreferencesName = "AppConfigPreferences"
    private const val name = "UserSharedPreferences"


    /**
     * provide app config preferences
     */

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AppConfigPreferencesInstance

    @Provides
    @Singleton
    @AppConfigPreferencesInstance
    fun provideAppPreferencesInstance(
        @ApplicationContext context: Context,
        cipherHelper: Rsa2048CipherHelper,
    ): CatchBottleSharedPreferences {

        return CatchBottleSharedPreferences(
            context,
            appConfigPreferencesName,
            cipherHelper
        )
    }

    @Provides
    @Singleton
    fun provideAppConfigRepository(
        @AppConfigPreferencesInstance
        preferences: CatchBottleSharedPreferences
    ): AppPreferencesRepository {
        return AppPreferencesRepositoryImpl(preferences)
    }


    /**
     * provide user config preferences
     */

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class CredentialsPreferencesInstance
    
    @Provides
    @Singleton
    @CredentialsPreferencesInstance
    fun provideCredentialsPreferencesInstance(
        @ApplicationContext context: Context,
        cipherHelper: Rsa2048CipherHelper,
    ): CatchBottleSharedPreferences {

        return CatchBottleSharedPreferences(
            context,
            name,
            cipherHelper
        )
    }

    @Provides
    @Singleton
    fun provideCredentialsDummyRepository(
        @CredentialsPreferencesInstance
        dao: CatchBottleSharedPreferences,
    ): CredentialsRepository {
        return CredentialsRepositoryImpl(dao)
    }
}
