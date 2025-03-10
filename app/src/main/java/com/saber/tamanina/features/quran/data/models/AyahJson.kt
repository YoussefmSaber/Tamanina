package com.saber.tamanina.features.quran.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Ayah(
    val number: Int,
    val text: String,
    val numberInSurah: Int,
    val juz: Int,
    val manzil: Int,
    val page: Int,
    val ruku: Int,
    val hizbQuarter: Int,
    val sajda: Boolean
)
