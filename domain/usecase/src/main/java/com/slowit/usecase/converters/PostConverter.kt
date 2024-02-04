package com.slowit.usecase.converters

import com.slowit.model.post.Post

internal fun com.slowit.model.rest.Post.toDomainPost(): Post =
    Post(
        image = this.media?.m,
        link = this.link,
        title = this.title
    )