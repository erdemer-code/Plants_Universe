package com.ozu.cs394.plantsuniverse.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plants(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int?,
    @ColumnInfo(name = "c_name")
    val commonName: String?,
    @ColumnInfo(name = "s_name")
    val scientificName: String?,
    @ColumnInfo(name = "f_name")
    val familyName: String?,
    @ColumnInfo(name = "img_url")
    val imageUrl: String?
)
