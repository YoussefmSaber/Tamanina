package com.saber.tamanina.features.home.domain.use_cases

import android.content.Context
import com.saber.tamanina.core.storage.SharedPrefsHelper
import com.saber.tamanina.core.utils.readJsonFile
import com.saber.tamanina.features.quran.data.models.SurahJson
import com.saber.tamanina.features.quran.domain.repository.QuranRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.serialization.json.Json
import javax.inject.Inject

/**
 *  `PreloadAppData` is responsible for preloading necessary data for the application on first launch.
 *  It checks if the database has been initialized and, if not, it preloads the data
 *  from the [QuranRepository] and then marks the database as initialized in [SharedPrefsHelper].
 *
 *  This class is designed to be used as a one-time operation during application startup,
 *  ensuring that required data is available before the user interacts with the app.
 *
 *  @property quranRepository The repository responsible for interacting with the Quran data.
 *  @property sharedPrefsHelper Helper for accessing and managing shared preferences. Used to track
 *  if database initialization is completed.
 *  @property context The application context, used for accessing resources and performing context-aware operations.
 */
class PreloadAppData @Inject constructor(
    private val quranRepository: QuranRepository,
    private val sharedPrefsHelper: SharedPrefsHelper,
    @ApplicationContext private val context: Context
) {
    companion object {
        private val json = Json { ignoreUnknownKeys = true }
    }

    suspend operator fun invoke() = coroutineScope {
        if (!sharedPrefsHelper.isDatabaseInitialized()) {
            val quranDeferred = async {
                val jsonData = context.readJsonFile("quran_data.json")
                val surahs: Map<String, SurahJson> = json.decodeFromString(jsonData)
                quranRepository.preloadData(surahs)
            }

            awaitAll(quranDeferred)
            sharedPrefsHelper.setDatabaseInitialized()
        }
    }
}