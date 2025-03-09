package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

class GetSurahs @Inject constructor(
    private val repository: QuranRepository
) {
    suspend operator fun invoke() =
        repository.getSurahs()
}