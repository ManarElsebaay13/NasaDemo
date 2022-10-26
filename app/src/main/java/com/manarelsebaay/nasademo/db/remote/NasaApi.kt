package com.manarelsebaay.nasademo.db.remote

import com.manarelsebaay.nasademo.db.model.MarsRoverResponse
import com.manarelsebaay.nasademo.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApi {


//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=FHAZ&page=1&api_key=DEMO_KEY
// https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=CHEMCAM&api_key=DEMO_KEY

    //get All Curiosity
    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000")
    suspend fun getPhotos(@Query("page") page:Int,@Query("api_key") apikey:String,):MarsRoverResponse

    //filtering
    @GET("/mars-photos/api/v1/rovers/{rover}/photos?sol=1000")
    suspend fun getMarsPhotos(@Path("rover") rover: String, @Query("page") page:Int,@Query("api_key") apikey:String): MarsRoverResponse
}