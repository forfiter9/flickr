package com.slowit.usecase

import com.slowit.model.post.Post
import com.slowit.post.repository.PostRepository
import com.slowit.usecase.converters.toDomainPost
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetSortedPostsUseCase @Inject constructor(
    private val postsRepository: PostRepository
) {
    suspend fun invoke(): List<Post> {
        val posts = postsRepository.getFromServer()
        return if (posts?.isNotEmpty() == true) {
            postsRepository.cachePosts(posts)
            posts.map { it.toDomainPost() }.sortedBy { it.publishedDateInMillis }
        } else {
            postsRepository.getCachedPosts().map { it.toDomainPost() }.sortedBy { it.publishedDateInMillis }
        }
    }
}