package com.slowit.model.converters

import com.slowit.model.rest.Post
import com.slowit.model.room.PostEntity

fun List<Post>?.toPostEntity() = this?.map {
    PostEntity(
        title = it.title,
        description = it.description,
        link = it.link,
        publishedDate = it.published,
        image = it.media?.imageLink
    )
} ?: emptyList()