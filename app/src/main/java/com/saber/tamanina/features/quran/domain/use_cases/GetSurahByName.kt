package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

/**
 * Use case class responsible for retrieving a Surah (chapter) from the Quran by its name.
 *
 * This class encapsulates the logic for fetching a Surah from the underlying data source (repository)
 * based on the provided Surah name. It utilizes the [QuranRepository] to interact with the data layer.
 *
 * @property repository The [QuranRepository] instance used to access Surah data. Injected via dependency injection.
 */
class GetSurahByName  @Inject constructor(private val repository: QuranRepository) {
    suspend operator fun invoke(surah: String) =
        repository.getSurahByName(surah)
}