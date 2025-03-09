package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

class GetSurahByName  @Inject constructor(private val repository: QuranRepository) {
    suspend operator fun invoke(surah: String) =
        repository.getSurahByName(surah)
}