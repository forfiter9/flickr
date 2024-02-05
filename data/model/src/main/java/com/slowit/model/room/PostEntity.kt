package com.slowit.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "link") val link: String?,
    @ColumnInfo(name = "published_date") val publishedDate: String?,
    @ColumnInfo(name = "image") val image: String?
)
