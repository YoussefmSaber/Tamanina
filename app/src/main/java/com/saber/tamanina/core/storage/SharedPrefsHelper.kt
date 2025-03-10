package com.saber.tamanina.core.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/**
 * Helper class for managing shared preferences.
 *
 * @param context The application context.
 */
class SharedPrefsHelper @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    /**
     * Checks if the database is initialized.
     *
     * @return `true` if the database is initialized, `false` otherwise.
     */
    fun isDatabaseInitialized(): Boolean {
        return sharedPreferences.getBoolean("is_database_initialized", false)
    }

    /**
     * Sets the database as initialized.
     */
    fun setDatabaseInitialized() {
        sharedPreferences.edit().putBoolean("is_database_initialized", true).apply()
    }
}