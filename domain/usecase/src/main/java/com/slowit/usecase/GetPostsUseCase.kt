package com.slowit.usecase

import android.util.Log
import com.slowit.model.post.Post
import com.slowit.post.repository.PostRepository
import com.slowit.usecase.converters.toDomainPost
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPostsUseCase @Inject constructor(
    private val postsRepository: PostRepository
) {
    suspend fun invoke(): List<Post>? = try {
        postsRepository.getFromServer().items?.map { it.toDomainPost() }
    } catch(e: Exception) {
        Log.e("Download exception", "invoke: $e", )
        emptyList()
    }// TODO add better handling response
}