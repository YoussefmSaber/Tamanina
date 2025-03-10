package com.saber.tamanina.features.quran.domain.repository

import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity
import com.saber.tamanina.features.quran.data.models.SurahJson

/**
 * Interface for interacting with the Quran data repository.
 * This interface defines methods for managing Surahs (chapters) and Ayahs (verses)
 * within the Quran database.
 */
interface QuranRepository {

    suspend fun insertSurah(surahs: SurahEntity)

    suspend fun insertAyahs(ayahs: List<AyahEntity>)

    suspend fun getSurahByNumber(number: Int): SurahEntity?

    suspend fun getSurahByName(name: String): SurahEntity?

    suspend fun getSurahs(): List<SurahEntity>

    suspend fun searchAyahs(ayah: String): List<AyahEntity>

    suspend fun preloadData(surahs: Map<String, SurahJson>)
}