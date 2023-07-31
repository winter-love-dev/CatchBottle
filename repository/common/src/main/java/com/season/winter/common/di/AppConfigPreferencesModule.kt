package com.season.winter.common.di

import android.content.Context
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048CipherHelper
import com.season.winter.common.util.sharedPrefrences.securePreferences.Rsa2048Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppConfigPreferencesModule {

    private const val name = "AppConfigPreferences"

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AppConfigPreferences

    @Provides
    @Singleton
    @AppConfigPreferences
    fun provideAppConfigPreferences(
        @ApplicationContext context: Context,
        cipherHelper: Rsa2048CipherHelper,
    ): Rsa2048Preferences {

        return Rsa2048Preferences(
            context,
            name,
            cipherHelper
        )
    }
}
