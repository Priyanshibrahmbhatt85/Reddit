package com.tinder.redditapp.data

import com.tinder.redditapp.data.model.Post
import retrofit2.http.GET

interface RedditApiService{
    @GET("hot.json")
    suspend fun getPost(): Post
}