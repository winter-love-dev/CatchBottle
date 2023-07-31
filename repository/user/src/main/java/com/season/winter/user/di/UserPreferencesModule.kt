package com.season.winter.user.di

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
object UserPreferencesModule {

    private const val name = "UserSharedPreferences"

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class UserPreferences


    @Provides
    @Singleton
    @UserPreferences
    fun provideUserPreferences(
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