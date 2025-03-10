package com.saber.tamanina.features.quran.data.repositories

import com.saber.tamanina.features.quran.data.data_sources.QuranDao
import com.saber.tamanina.features.quran.data.models.AyahEntity
import com.saber.tamanina.features.quran.data.models.SurahEntity
import com.saber.tamanina.features.quran.data.models.SurahJson
import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of the QuranRepository interface.
 * This class provides methods to interact with the Quran data source.
 */
class QuranRepositoryImpl @Inject constructor(
    private val quranDao: QuranDao
) : QuranRepository {

    /**
     * Inserts a Surah into the database.
     * @param surahs The SurahEntity to be inserted.
     */
    override suspend fun insertSurah(surahs: SurahEntity) {
        quranDao.insertSurah(surahs)
    }

    /**
     * Inserts a list of Ayahs into the database.
     * @param ayahs The list of AyahEntity to be inserted.
     */
    override suspend fun insertAyahs(ayahs: List<AyahEntity>) {
        quranDao.insertAyahs(ayahs)
    }

    /**
     * Retrieves a Surah by its number.
     * @param number The number of the Surah.
     * @return The SurahEntity if found, null otherwise.
     */
    override suspend fun getSurahByNumber(number: Int): SurahEntity? {
        return quranDao.getSurahByNumber(number)
    }

    /**
     * Retrieves a Surah by its name.
     * @param name The name of the Surah.
     * @return The SurahEntity if found, null otherwise.
     */
    override suspend fun getSurahByName(name: String): SurahEntity? {
        return quranDao.getSurahByName(name)
    }

    /**
    -     * Retrieves all Surahs.
    -     * @return A list of SurahEntity.
    -     */
    override suspend fun getSurahs(): List<SurahEntity> {
        return quranDao.getSurahs()
    }

    /**
     * Searches for Ayahs (verses) in the Quran that contain the specified text.
     *
     * This function performs a search across all Ayahs stored in the local database.
     * It returns a list of AyahEntity objects that match the provided search term.
     * The search is performed in a case-insensitive manner and will find partial matches within an Ayah's text.
     *
     * @param ayah The text string to search for within the Ayahs. This can be a single word, multiple words, or even a partial word.
     * @return A list of AyahEntity objects representing the Ayahs that contain the specified search text.
     *         Returns an empty list if no matching Ayahs are found.
     * @throws Exception If any error occurs during the database query operation.
     */
    override suspend fun searchAyahs(ayah: String): List<AyahEntity> {
        return quranDao.searchAyahs(ayah)
    }

    /**
     * Preloads Quran data from a JSON file into the database.
     *
     * This function reads a JSON file named "quran_data.json" located in the application's assets directory,
     * parses it to extract Surah and Ayah information, and then inserts this data into the local database
     * via the `quranDao`.
     *
     * The JSON file is expected to contain a structure where the root is a map.
     * Each entry in the map represents a Surah (chapter) and contains details about the Surah itself
     * and a list of its Ayahs (verses).
     *
     * This function is designed to be executed once, typically during the application's initial setup,
     * to populate the database with the Quran's core content.
     *
     * The function uses Kotlin Serialization library to decode the JSON, ignoring unknown keys for flexibility.
     * It also leverages Kotlin Coroutines to perform the database operations asynchronously.
     *
     * @param surahs the .
     * @throws kotlinx.serialization.SerializationException If the JSON data is malformed or does not match the expected schema.
     * @throws java.io.FileNotFoundException If the "quran_data.json" file is not found in the assets.
     * @throws java.io.IOException If an error occurs while reading the JSON file.
     */
    override suspend fun preloadData(surahs: Map<String, SurahJson>) = withContext(Dispatchers.IO) {
        surahs.values.forEach { surahData ->
            val surah = SurahEntity(
                number = surahData.number,
                name = surahData.name,
                revelationType = surahData.revelationType,
                numberOfAyahs = surahData.numberOfAyahs
            )

            quranDao.insertSurah(surah)
            val ayahEntity = surahData.ayahs.map { ayahData ->
                AyahEntity(
                    number = ayahData.number,
                    surahNumber = surahData.number,
                    text = ayahData.text,
                    numberInSurah = ayahData.numberInSurah,
                    juz = ayahData.juz,
                    page = ayahData.page,
                    hizbQuarter = ayahData.hizbQuarter,
                    sajda = ayahData.sajda,
                    manzil = ayahData.manzil,
                    ruku = ayahData.ruku
                )
            }
            quranDao.insertAyahs(ayahEntity)
        }
    }
}