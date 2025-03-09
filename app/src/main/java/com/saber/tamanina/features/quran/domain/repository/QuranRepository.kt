package com.saber.tamanina.features.quran.domain.repository

import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity

interface QuranRepository {

    suspend fun insertSurahs(surahs: List<SurahEntity>)

    suspend fun insertAyahs(ayahs: List<AyahEntity>)

    suspend fun getSurahByNumber(number: Int): SurahEntity?

    suspend fun getSurahByName(name: String): SurahEntity?

    suspend fun getSurahs(): List<SurahEntity>

    suspend fun searchAyahs(ayah: String): List<AyahEntity>
}