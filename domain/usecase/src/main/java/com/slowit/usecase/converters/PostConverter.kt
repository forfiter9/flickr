package com.slowit.usecase.converters

import com.slowit.model.post.Post
import com.slowit.model.room.PostEntity
import org.jsoup.Jsoup
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

internal fun com.slowit.model.rest.Post.toDomainPost(): Post =
    Post(
        image = this.media?.imageLink,
        link = this.link,
        title = this.title,
        description = Jsoup.parse(description).text(),
        publishedDateInMillis = this.published?.toMillis() ?: 0L
    )
internal fun PostEntity.toDomainPost(): Post =
    Post(
        image = this.image,
        link = this.link,
        title = this.title,
        description = Jsoup.parse(description).text(),
        publishedDateInMillis = this.publishedDate?.toMillis() ?: 0L
    )

internal fun String.toMillis(pattern: String = "yyyy-MM-dd'T'HH:mm:ss'Z'"): Long {
    val inputFormat = SimpleDateFormat(pattern, Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    val date = inputFormat.parse(this) ?: throw IllegalArgumentException("Invalid date format. Please provide the date in the format $pattern.")
    return date.time
}