package com.saber.tamanina.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saber.tamanina.features.quran.data.data_sources.QuranDao
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity

@Database(entities = [SurahEntity::class, AyahEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun quranDao(): QuranDao
}