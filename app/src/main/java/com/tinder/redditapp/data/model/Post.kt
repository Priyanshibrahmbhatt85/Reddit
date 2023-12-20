package com.tinder.redditapp.data.model

data class Post(
    var kind: String? = null,
    val data: PostData? = PostData()
)