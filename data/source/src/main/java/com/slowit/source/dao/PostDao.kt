package com.slowit.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.slowit.model.room.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM postentity")
    fun getAll(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    fun insertAll(posts: List<PostEntity>)

    @Query("DELETE FROM postentity")
    fun clearTable()
}