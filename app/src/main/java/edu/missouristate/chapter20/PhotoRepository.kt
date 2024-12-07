package edu.missouristate.chapter20

import android.util.Log
import edu.missouristate.chapter20.api.FlickrApi
import edu.missouristate.chapter20.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

private const val TAG = "PhotoRepository"

class PhotoRepository {

    private val flickrApi : FlickrApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
//            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        flickrApi = retrofit.create()
//        Log.d(TAG, "Random Generated Date: ${randomDate(LocalDate.of(2020, 1, 1), LocalDate.now())}")
//        Log.d(TAG, "Random Generated Date: ${randomDate(LocalDate.of(2020, 1, 1), LocalDate.now())}")
//        Log.d(TAG, "Random Generated Date: ${randomDate(LocalDate.of(2020, 1, 1), LocalDate.now())}")
//        Log.d(TAG, "Random Generated Date: ${randomDate(LocalDate.of(2020, 1, 1), LocalDate.now())}")
    }

//    suspend fun fetchContents() = flickrApi.fetchContents()
//    suspend fun fetchPhotos() = flickrApi.fetchPhotos()
    suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos(
        date = randomDate(LocalDate.of(2020, 1, 1), LocalDate.now()).toString())
        .photos.galleryItems

    private fun randomDate(start: LocalDate, end: LocalDate): LocalDate {
        val daysBetween = ChronoUnit.DAYS.between(start, end)
        val randomDays = Random.nextLong(daysBetween + 1)
        val generatedDate = start.plusDays(randomDays)
        Log.d(TAG, "Random Generated Date: $generatedDate")
        return generatedDate
    }

}