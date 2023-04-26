package com.example.youtube.model

data class Snippet(
    var channelId: String? = null,
    var channelTitle: String? = null,
    var description: String? = null,
    var localized: Localized? = null,
    var publishedAt: String? = null,
    var thumbnails: Thumbnails? = null,
    var title: String? = null,
    var resourceId: ResourceId? = null
)

data class ResourceId(
    var kind: String? = null,
    var videoId: String? = null,
)
