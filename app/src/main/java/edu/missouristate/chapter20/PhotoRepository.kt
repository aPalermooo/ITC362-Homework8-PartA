package edu.missouristate.chapter20

import edu.missouristate.chapter20.api.FlickrApi
import edu.missouristate.chapter20.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

class PhotoRepository {

    private val flickrApi : FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        flickrApi = retrofit.create()
    }

//    suspend fun fetchContents() = flickrApi.fetchContents()
//    suspend fun fetchPhotos() = flickrApi.fetchPhotos()
    suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos(date = "2020-04-20").photos.galleryItems

    private fun randomDate(start: LocalDate, end: LocalDate): LocalDate {
        val daysBetween = ChronoUnit.DAYS.between(start, end)
        val randomDays = Random.nextLong(daysBetween + 1)
        return start.plusDays(randomDays)
    }

}