package com.slowit.usecase.converters

import com.slowit.model.post.Post
import org.jsoup.Jsoup

internal fun com.slowit.model.rest.Post.toDomainPost(): Post =
    Post(
        image = this.media?.imageLink,
        link = this.link,
        title = this.title,
        description = Jsoup.parse(description).text()
    )