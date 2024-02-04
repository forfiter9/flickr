package com.slowit.post.repository

import com.slowit.model.rest.PostsResponse as restPosts

interface PostRepository {
    suspend fun getFromServer(): restPosts
}