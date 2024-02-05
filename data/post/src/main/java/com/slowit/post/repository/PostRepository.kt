package com.slowit.post.repository

import com.slowit.model.rest.Post
import com.slowit.model.room.PostEntity

interface PostRepository {
    suspend fun getFromServer(): List<Post>?
    suspend fun cachePosts(posts: List<Post>)
    suspend fun getCachedPosts(): List<PostEntity>
}