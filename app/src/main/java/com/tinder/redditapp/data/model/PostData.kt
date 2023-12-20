package com.tinder.redditapp.data.model

data class PostData(
    val after: String? = null,
    val dist: Int? = null,
    val modhash: String? = null,
    val geoFilter: String? = null,
    val children: List<Children> = emptyList(),
    val before: String? = null
)