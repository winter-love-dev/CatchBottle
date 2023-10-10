package com.season.winter.core.data.repository.di.preferences

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048CipherHelper
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048PreferencesDao
import com.season.winter.core.data.repository.AppPreferencesRepositoryImpl
import com.season.winter.core.domain.repository.AppPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppPreferencesModule {

    private const val name = "AppConfigPreferences"

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AppConfigPreferences

    @Provides
    @Singleton
    @AppConfigPreferences
    fun provideAppPreferencesDao(
        @ApplicationContext context: Context,
        cipherHelper: Rsa2048CipherHelper,
    ): Rsa2048PreferencesDao {

        return Rsa2048PreferencesDao(
            context,
            name,
            cipherHelper
        )
    }

    @Provides
    @Singleton
    fun provideAppConfigPreferences(
        @AppConfigPreferences
        dao: Rsa2048PreferencesDao
    ): AppPreferencesRepository {
        return AppPreferencesRepositoryImpl(dao)
    }
}
