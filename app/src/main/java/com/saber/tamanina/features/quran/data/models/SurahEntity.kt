package com.saber.tamanina.features.quran.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Represents the table surahs in the application database
 */
@Serializable
@Entity(tableName = "surahs")
data class SurahEntity (
    @PrimaryKey val number: Int,
    val name: String,
    val revelationType: String,
    val numberOfAyahs: Int,
)