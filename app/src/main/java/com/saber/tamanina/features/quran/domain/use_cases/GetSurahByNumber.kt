package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

/**
 * Use case class responsible for fetching a specific Surah from the Quran repository by its number.
 *
 * This class encapsulates the logic for retrieving a Surah, decoupling the data access layer
 * (QuranRepository) from the presentation layer or other parts of the application that might
 * need to retrieve Surahs.
 *
 * @property repository The repository responsible for providing access to Quran data.
 * It's injected via constructor injection.
 */
class GetSurahByNumber @Inject constructor(
    private val repository: QuranRepository
) {
    suspend operator fun invoke(surah: Int) =
        repository.getSurahByNumber(surah)
}