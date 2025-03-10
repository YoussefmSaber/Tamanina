package com.saber.tamanina.features.quran.domain.use_cases

import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import javax.inject.Inject

/**
 * `GetAyahFromQuran` is a Use Case class responsible for retrieving a specific Ayah (verse) from the Quran.
 *
 * It encapsulates the logic of searching for an Ayah based on a provided string identifier (e.g., "2:255" for Ayah 255 of Surah 2).
 * It delegates the actual data fetching to the [QuranRepository].
 *
 * This class follows the Use Case pattern, promoting clean architecture by separating business logic
 * from data access and presentation concerns.
 *
 * @property repository The [QuranRepository] instance responsible for providing access to the Quran data.
 *                     Injected via constructor injection.
 */
class GetAyahFromQuran @Inject constructor(private val repository: QuranRepository){
    suspend operator fun invoke(ayah: String) =
        repository.searchAyahs(ayah)
}