package com.saber.tamanina.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saber.tamanina.features.quran.data.data_sources.QuranDao
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity

/**
 * The Room database for the application.
 * It contains the database configuration and serves as the main access point to the persisted data.
 */
@Database(entities = [SurahEntity::class, AyahEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    /**
     * Provides access to the Quran data access object (DAO).
     * @return QuranDao The DAO for Quran-related database operations.
     */
    abstract fun quranDao(): QuranDao
}