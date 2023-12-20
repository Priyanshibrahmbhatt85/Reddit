package com.tinder.redditapp.data.model

data class ChildData(
    val authorFullname: String? = null,
    val approvedAtUtc: String? = null,
    val subreddit: String? = null,
    val title: String? = "",
    val thumbnail: String? = "",
    val createdUtc: Double? = null,
    val media: Media? = Media(),
    val isVideo: Boolean? = null
)

data class Media(
    val redditVideo: RedditVideo? = RedditVideo()
)

data class RedditVideo(

    val bitrateKbps: Int? = null,
    val fallbackUrl: String? = null,
    val hasAudio: Boolean? = null,
    val height: Int? = null,
    val width: Int? = null,
    val scrubberMediaUrl: String? = null,
    val dashUrl: String? = null,
    val duration: Int? = null,
    val hlsUrl: String? = null,
    val isGif: Boolean? = null,
    val transcodingStatus: String? = null

)

//val selftext: String? = null,
//val authorFullname: String? = null,
//val title: String? = null,
//val subredditNamePrefixed: String? = null,
//val hidden: Boolean? = null,
//val pwls: Int? = null,
//val linkFlairCssClass: String? = null,
//val downs: Int? = null,
//val thumbnailHeight: String? = null,
//val name: String? = null,
//val subredditType: String? = null,
//val thumbnailWidth: String? = null,
//val authorFlairTemplateId: String? = null,
//val isOriginalContent: Boolean? = null,
//val userReports: ArrayList<String> = arrayListOf(),
//val secureMedia: String? = null,
//val isRedditMediaDomain: Boolean? = null,
//val isMeta: Boolean? = null,
//val category: String? = null,
//val authorPremium: Boolean? = null,
//val thumbnail: String? = null,
//val authorFlairRichtext: ArrayList<String> = arrayListOf(),
//val contentCategories: String? = null,
//val isSelf: Boolean? = null,
//val modNote: String? = null,
//val created: Int? = null,
//val linkFlairType: String? = null,
//val wls: Int? = null,
//val domain: String? = null,
//val likes: String? = null,
//val viewCount: String? = null,
//val mediaOnly: Boolean? = null,
//val locked: Boolean? = null,
//val subredditId: String? = null,
//val id: String? = null,
//val author: String? = null,
//val discussionType: String? = null,
//val numComments: Int? = null,
//val contestMode: Boolean? = null,
//val authorPatreonFlair: Boolean? = null,
//val authorFlairTextColor: String? = null,
//val parentWhitelistStatus: String? = null,
//val url: String? = null,

