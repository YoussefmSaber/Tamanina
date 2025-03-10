package com.saber.tamanina.core.utils

import android.content.Context
import android.util.Log
import kotlinx.io.IOException

fun Context.readJsonFile(fileName: String): String {
    return try {
        assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (e: IOException) {
        Log.e("PreloadAppData", "Error reading JSON file: $fileName", e)
        "{}"
    }
}