package edu.missouristate.chapter20.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class GalleryItem (
    val title:String,
    val id:String,
    @Json(name = "url_s") val url:String
) {

}