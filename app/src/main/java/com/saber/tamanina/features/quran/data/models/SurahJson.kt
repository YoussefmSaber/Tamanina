package com.saber.tamanina.features.quran.data.models

import kotlinx.serialization.Serializable


@Serializable
data class SurahJson(
    val number: Int,
    val name: String,
    val revelationType: String,
    val numberOfAyahs: Int,
    val ayahs: List<Ayah>
)