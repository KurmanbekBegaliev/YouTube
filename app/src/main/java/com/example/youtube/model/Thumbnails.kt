package com.example.youtube.model

data class Thumbnails(
    var default: Default? = null,
    var high: High? = null,
    var maxres: Maxres? = null,
    var medium: Medium? = null,
    var standard: Standard? = null
)