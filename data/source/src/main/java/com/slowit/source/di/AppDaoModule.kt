package com.slowit.source.di

import com.slowit.source.dao.PostDao
import com.slowit.source.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDaoModule {

    @Provides
    @Singleton
    fun provideAudioDao(appDatabase: AppDatabase): PostDao = appDatabase.postDao()
}