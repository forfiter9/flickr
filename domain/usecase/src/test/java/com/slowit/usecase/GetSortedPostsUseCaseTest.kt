package com.slowit.usecase

import com.slowit.model.rest.Post
import com.slowit.model.room.PostEntity
import com.slowit.post.repository.PostRepository
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetSortedPostsUseCaseTest {

    private val mockPostsRepository: PostRepository = mockk()

    private val systemUnderTest = GetSortedPostsUseCase(
        postsRepository = mockPostsRepository
    )

    @Test
    fun `check if cache method is called after successfully downloaded posts`() = runTest {
        coEvery { mockPostsRepository.getFromServer() } returns REST_POSTS
        coEvery { mockPostsRepository.cachePosts(REST_POSTS) } returns Unit
        systemUnderTest.invoke()
        coVerify { mockPostsRepository.cachePosts(REST_POSTS) }
    }

    @Test
    fun `check if rest posts are sorted correctly`() = runTest {
        coEvery { mockPostsRepository.getFromServer() } returns REST_POSTS
        coEvery { mockPostsRepository.cachePosts(REST_POSTS) } returns Unit
        val actual = systemUnderTest.invoke()
        actual.first().description shouldBe "newest"
    }

    @Test
    fun `check if get cache method is called after failed download posts`() = runTest {
        coEvery { mockPostsRepository.getFromServer() } returns emptyList()
        coEvery { mockPostsRepository.cachePosts(REST_POSTS) } returns Unit
        coEvery { mockPostsRepository.getCachedPosts() } returns ROOM_POSTS
        systemUnderTest.invoke()
        coVerify(exactly = 0) { mockPostsRepository.cachePosts(REST_POSTS) }
        coVerify { mockPostsRepository.getCachedPosts() }
    }

    @Test
    fun `check if room posts are sorted correctly`() = runTest {
        coEvery { mockPostsRepository.getFromServer() } returns emptyList()
        coEvery { mockPostsRepository.cachePosts(REST_POSTS) } returns Unit
        coEvery { mockPostsRepository.getCachedPosts() } returns ROOM_POSTS

        val actual = systemUnderTest.invoke()
        actual.first().description shouldBe "newest"
    }

    companion object {
        private val REST_POSTS = listOf(
            Post(title = "test1", link = "test1",  media = null, date_taken = null, description = "oldest", published = "2024-02-04T15:50:06Z", author = null, author_id = null, tags = null),
            Post(title = "test2", link = "test2",  media = null, date_taken = null, description = "desc", published = "2024-03-04T15:50:06Z", author = null, author_id = null, tags = null),
            Post(title = "test3", link = "test3",  media = null, date_taken = null, description = "newest", published = "2024-04-04T15:50:06Z", author = null, author_id = null, tags = null),
        )
        private val ROOM_POSTS = listOf(
            PostEntity(title = "test1", link = "test1", image = "image", description = "oldest", publishedDate = "2024-02-04T15:50:06Z"),
            PostEntity(title = "test2", link = "test2", image = "image", description = "desc", publishedDate = "2024-03-04T15:50:06Z"),
            PostEntity(title = "test3", link = "test3", image = "image", description = "newest", publishedDate = "2024-04-04T15:50:06Z"),
        )
    }
}