package com.saber.tamanina.features.quran.data.repositories

import com.saber.tamanina.features.quran.data.data_sources.QuranDao
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity
import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

class QuranRepositoryImpl @Inject constructor(
    private val quranDao: QuranDao
): QuranRepository {

    override suspend fun insertSurahs(surahs: List<SurahEntity>) {
        quranDao.insertSurahs(surahs)
    }

    override suspend fun insertAyahs(ayahs: List<AyahEntity>) {
        quranDao.insertAyahs(ayahs)
    }

    override suspend fun getSurahByNumber(number: Int): SurahEntity? {
        return quranDao.getSurahByNumber(number)
    }

    override suspend fun getSurahByName(name: String): SurahEntity? {
        return quranDao.getSurahByName(name)
    }

    override suspend fun getSurahs(): List<SurahEntity> {
        return quranDao.getSurahs()
    }

    override suspend fun searchAyahs(ayah: String): List<AyahEntity> {
        return quranDao.searchAyahs(ayah)
    }
}