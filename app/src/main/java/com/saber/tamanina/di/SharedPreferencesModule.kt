package com.saber.tamanina.di

import android.content.Context
import com.saber.tamanina.core.storage.SharedPrefsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Dagger module to provide SharedPreferences related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    /**
     * Provides a singleton instance of SharedPrefsHelper.
     *
     * @param context The application context.
     * @return A SharedPrefsHelper instance.
     */
    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPrefsHelper {
        return SharedPrefsHelper(context)
    }
}