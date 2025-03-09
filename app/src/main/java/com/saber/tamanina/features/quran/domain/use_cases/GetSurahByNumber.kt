package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

class GetSurahByNumber @Inject constructor(
    private val repository: QuranRepository
) {
    suspend operator fun invoke(surah: Int) =
        repository.getSurahByNumber(surah)
}