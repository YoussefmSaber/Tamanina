package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

class GetAyahFromQuran @Inject constructor(private val repository: QuranRepository){
    suspend operator fun invoke(ayah: String) =
        repository.searchAyahs(ayah)
}