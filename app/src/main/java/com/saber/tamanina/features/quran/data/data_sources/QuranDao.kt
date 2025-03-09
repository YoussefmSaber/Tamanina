package com.saber.tamanina.features.quran.data.data_sources

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity

@Dao
interface QuranDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurahs(surahs: List<SurahEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyahs(ayahs: List<AyahEntity>)

    @Query("SELECT * FROM surahs WHERE number = :number")
    suspend fun getSurahByNumber(number: Int): SurahEntity?

    @Query("SELECT * FROM surahs WHERE name = :name")
    suspend fun getSurahByName(name: String): SurahEntity?

    @Query("SELECT * FROM surahs")
    suspend fun getSurahs(): List<SurahEntity>

    @Query("SELECT * FROM ayahs WHERE text LIKE '%' || :ayah || '%'")
    suspend fun searchAyahs(ayah: String): List<AyahEntity>
}