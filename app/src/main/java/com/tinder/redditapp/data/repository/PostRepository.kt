package com.tinder.redditapp.data.repository

import com.tinder.redditapp.data.RedditApiService
import com.tinder.redditapp.data.Result
import com.tinder.redditapp.data.model.HotPosts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: RedditApiService){
    suspend fun getListOfPost(): Flow<Result<List<HotPosts>>> = flow {
        try {
            emit(Result.Loading)
            val children = apiService.getPost().data?.children ?: emptyList()
            emit(Result.Success(children))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }.flowOn(Dispatchers.IO)
}