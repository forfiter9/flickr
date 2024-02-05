package com.slowit.post

import android.util.Log
import com.slowit.post.repository.DBAndRestPostRepository
import com.slowit.source.RestPostDataSource
import com.slowit.source.RoomPostDataSource
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DBAndRestRepositoryTest {

    private val mockRestPostDataSource: RestPostDataSource = mockk()
    private val mockRoomPostDataSource: RoomPostDataSource = mockk()

    private val systemUnderTest = DBAndRestPostRepository(
        restPostDataSource = mockRestPostDataSource,
        roomPostDataSource = mockRoomPostDataSource
    )

    @Test
    fun `when rest post data source throw exception empty list is returned`() = runTest {
        mockkStatic(Log::class)
        every { Log.e(any(), any()) } returns 0
        coEvery { mockRestPostDataSource.getPosts() } throws Exception()
        val actual = systemUnderTest.getFromServer()
        actual shouldBe emptyList()
    }
}