package com.season.winter.core.data.repository.di.preferences

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.cipher.Rsa2048CipherHelper
import com.season.winter.common.util.sharedPrefrences.CatchBottleSharedPreferences
import com.season.winter.core.data.repository.AppPreferencesRepositoryImpl
import com.season.winter.core.data.repository.CredentialsDummyRepositoryImpl
import com.season.winter.core.domain.repository.AppPreferencesRepository
import com.season.winter.core.domain.repository.CredentialsDummyRepository
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


    /** provide app config preferences  */

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AppConfigPreferences

    @Provides
    @Singleton
    @AppConfigPreferences
    fun provideAppPreferences(
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
    fun provideAppConfigPreferences(
        @AppConfigPreferences
        preferences: CatchBottleSharedPreferences
    ): AppPreferencesRepository {
        return AppPreferencesRepositoryImpl(preferences)
    }




    /** provide user config preferences  */

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UserPreferences
    
    @Provides
    @Singleton
    @UserPreferences
    fun provideUserPreferences(
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
    fun provideUserPreferencesRepository(
        @UserPreferences
        dao: CatchBottleSharedPreferences,
    ): CredentialsDummyRepository {
        return CredentialsDummyRepositoryImpl(dao)
    }
}
