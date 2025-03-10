package com.saber.tamanina.features.quran.data.data_sources

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity

/**
 * Data Access Object for the Quran database.
 * Here we define all the queries for the database.
 * All queries are suspended functions to be called from a coroutine.
 */
@Dao
interface QuranDao {

    /**
     * Inserts a Surah into the database.
     * If the Surah already exists, it will be replaced.
     *
     * @param surahs The SurahEntity to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSurah(surahs: SurahEntity)

    /**
     * Inserts a list of Ayahs into the database.
     * If any Ayah already exists, it will be replaced.
     *
     * @param ayahs The list of AyahEntity to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAyahs(ayahs: List<AyahEntity>)

    /**
     * Retrieves a Surah by its number.
     *
     * @param number The number of the Surah.
     * @return The SurahEntity with the specified number, or null if not found.
     */
    @Query("SELECT * FROM surahs WHERE number = :number")
    suspend fun getSurahByNumber(number: Int): SurahEntity?

    /**
     * Retrieves a Surah by its name.
     *
     * @param name The name of the Surah.
     * @return The SurahEntity with the specified name, or null if not found.
     */
    @Query("SELECT * FROM surahs WHERE name = :name")
    suspend fun getSurahByName(name: String): SurahEntity?

    /**
     * Retrieves all Surahs from the database.
     *
     * @return A list of all SurahEntity.
     */
    @Query("SELECT * FROM surahs")
    suspend fun getSurahs(): List<SurahEntity>

    /**
     * Searches for Ayahs containing the specified text.
     *
     * @param ayah The text to search for within Ayahs.
     * @return A list of AyahEntity that contain the specified text.
     */
    @Query("SELECT * FROM ayahs WHERE text LIKE '%' || :ayah || '%'")
    suspend fun searchAyahs(ayah: String): List<AyahEntity>
}