package com.saber.tamanina.di

import android.content.Context
import com.saber.tamanina.core.storage.SharedPrefsHelper
import com.saber.tamanina.features.home.domain.use_cases.PreloadAppData
import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePreloadData(
        quranRepository: QuranRepository,
        sharedPrefsHelper: SharedPrefsHelper,
        @ApplicationContext context: Context
    ): PreloadAppData {
        return PreloadAppData(
            quranRepository,
            sharedPrefsHelper,
            context
        )
    }
}