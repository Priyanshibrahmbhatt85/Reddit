package com.tinder.redditapp.di

import com.tinder.redditapp.data.RedditApiService
import com.tinder.redditapp.data.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.reddit.com/r/aww/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRedditApiService(retrofit: Retrofit): RedditApiService {
        return retrofit.create(RedditApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePostRepository(apiService: RedditApiService): PostRepository {
        return PostRepository(apiService)
    }
}
