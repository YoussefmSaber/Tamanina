package com.saber.tamanina.di

import android.content.Context
import androidx.room.Room
import com.saber.tamanina.core.storage.AppDatabase
import com.saber.tamanina.features.quran.data.data_sources.QuranDao
import com.saber.tamanina.features.quran.data.repositories.QuranRepositoryImpl
import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger module to provide database-related dependencies.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     * Provides the singleton instance of [AppDatabase].
     *
     * @param context The application context.
     * @return The [AppDatabase] instance.
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "tamanina_database"
        ).build()
    }

    /**
     * Provides the [QuranDao] instance.
     *
     * @param appDatabase The [AppDatabase] instance.
     * @return The [QuranDao] instance.
     */
    @Provides
    @Singleton
    fun provideQuranDao(appDatabase: AppDatabase): QuranDao {
        return appDatabase.quranDao()
    }

    /**
     * Provides the [QuranRepository] instance.
     *
     * @param quranDao The [QuranDao] instance.
     * @return The [QuranRepository] instance.
     */
    @Provides
    @Singleton
    fun provideQuranRepository(quranDao: QuranDao): QuranRepository {
        return QuranRepositoryImpl(quranDao)
    }
}