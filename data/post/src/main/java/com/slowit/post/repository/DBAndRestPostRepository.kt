package com.slowit.post.repository

import com.slowit.model.rest.PostsResponse
import com.slowit.source.PostDataSource
import javax.inject.Inject

internal class DBAndRestPostRepository @Inject constructor(
    private val postDataSource: PostDataSource
): PostRepository {
    override suspend fun getFromServer(): PostsResponse {
        return postDataSource.getPosts()
    }
}
// add database implementation