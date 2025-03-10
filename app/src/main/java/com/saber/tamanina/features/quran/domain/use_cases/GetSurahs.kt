package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

/**
 * Use case class responsible for fetching the list of Surahs (chapters) from the Quran repository.
 *
 * This class acts as an intermediary between the repository layer and the presentation layer,
 * encapsulating the logic for retrieving Surah data. It utilizes the `QuranRepository`
 * to perform the actual data fetching and provides a simplified way for other components
 * to access this information.
 *
 * The class is designed to be used within a dependency injection framework (like Hilt)
 * through the `@Inject` annotation.
 *
 * @property repository An instance of `QuranRepository` used to access the Quran data source.
 */
class GetSurahs @Inject constructor(
    private val repository: QuranRepository
) {
    suspend operator fun invoke() = repository.getSurahs()
}