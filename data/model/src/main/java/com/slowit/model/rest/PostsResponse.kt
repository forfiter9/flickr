package com.slowit.model.rest

data class PostsResponse(
    val title: String?,
    val link: String?,
    val description: String?,
    val modified: String?,
    val generator: String?,
    val items: List<Post>?
)
