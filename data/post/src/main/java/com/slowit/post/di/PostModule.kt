package com.slowit.post.di

import com.slowit.post.repository.DBAndRestPostRepository
import com.slowit.post.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostModule {
    @Binds
    @Singleton
    internal abstract fun bindPostRepository(
        restChannelRepository: DBAndRestPostRepository
    ): PostRepository
}