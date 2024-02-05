package com.slowit.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.slowit.model.room.PostEntity
import com.slowit.source.dao.PostDao

@Database(entities = [PostEntity::class], version = Constants.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}