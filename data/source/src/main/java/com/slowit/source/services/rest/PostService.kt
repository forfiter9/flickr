package com.slowit.source.services.rest

import com.slowit.model.rest.PostsResponse
import retrofit2.http.GET

interface PostService {
    @GET("/services/feeds/photos_public.gne?format=json&tags=cat&nojsoncallback=1")
    suspend fun getPosts(): PostsResponse
}