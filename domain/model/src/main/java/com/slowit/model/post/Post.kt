package com.slowit.model.post

data class Post(
    val image: String?,
    val link: String?,
    val title: String?,
    val description: String?,
    val publishedDateInMillis: Long
)
