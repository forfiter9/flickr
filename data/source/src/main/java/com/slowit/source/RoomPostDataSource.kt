package com.slowit.source

import androidx.room.withTransaction
import com.slowit.model.converters.toPostEntity
import com.slowit.model.rest.Post
import com.slowit.source.dao.PostDao
import com.slowit.source.db.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomPostDataSource @Inject constructor(
    private val appDatabase: AppDatabase,
    private val postDao: PostDao
){

    suspend fun cachePosts(posts: List<Post>?) {
        appDatabase.withTransaction {
            postDao.clearTable()
            postDao.insertAll(posts.toPostEntity())
        }
    }

    suspend fun getCachedPosts() = postDao.getAll()
}