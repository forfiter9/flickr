package com.slowit.post.repository

import android.util.Log
import com.slowit.model.rest.Post
import com.slowit.model.room.PostEntity
import com.slowit.source.RestPostDataSource
import com.slowit.source.RoomPostDataSource
import javax.inject.Inject

internal class DBAndRestPostRepository @Inject constructor(
    private val restPostDataSource: RestPostDataSource,
    private val roomPostDataSource: RoomPostDataSource
): PostRepository {
    override suspend fun getFromServer(): List<Post>? {
        try {
            val serverResponse = restPostDataSource.getPosts()
            serverResponse.onSuccess { _, requestResponse ->
                return requestResponse?.items
            }.onError { _, erroBody ->
                Log.e("DBAndRestPostRepository", "getPosts: ${erroBody.toString()}",)
            }
        } catch (e: Exception) {
            Log.e("DBAndRestPostRepository", "getPosts: $e",)
        }
        return emptyList()
    }

    override suspend fun cachePosts(posts: List<Post>) =
        roomPostDataSource.cachePosts(posts)

    override suspend fun getCachedPosts(): List<PostEntity> =
        roomPostDataSource.getCachedPosts()
}