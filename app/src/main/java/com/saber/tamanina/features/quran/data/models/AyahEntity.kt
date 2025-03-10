package com.saber.tamanina.features.quran.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Represents the table ayah in the application database
 */
@Serializable
@Entity(tableName = "ayahs",
    foreignKeys = [
        ForeignKey(
            entity = SurahEntity::class,
            parentColumns = ["number"],
            childColumns = ["surahNumber"],
            onDelete = ForeignKey.CASCADE,
        )
    ],
    indices = [Index(value = ["surahNumber"])]
)
data class AyahEntity (
    @PrimaryKey val number: Int,
    val surahNumber: Int,
    val text: String,
    val numberInSurah: Int,
    val juz: Int,
    val manzil: Int,
    val page: Int,
    val ruku: Int,
    val hizbQuarter: Int,
    val sajda: Boolean
)