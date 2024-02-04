package com.slowit.source

import com.slowit.source.services.rest.PostService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostDataSource @Inject constructor(
    private val postService: PostService
){
    suspend fun getPosts() = postService.getPosts()
}