package edu.missouristate.chapter20.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlickrResponse (
    val photos: PhotoResponse
)