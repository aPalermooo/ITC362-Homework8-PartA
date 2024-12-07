package edu.missouristate.chapter20.api

import retrofit2.http.Query
import retrofit2.http.GET

private const val API_KEY = "8dc1548b0dc63d9e1ea64799af44ee0e"

interface FlickrApi {

//    @GET("/")
//    suspend fun fetchContents(): String

    @GET("services/rest/")
    suspend fun fetchPhotos(
        @Query("method") method: String = "flickr.interestingness.getList",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("extras") extras: String = "url_s",

//        Part B
        @Query("date") date: String
    ): FlickrResponse
}