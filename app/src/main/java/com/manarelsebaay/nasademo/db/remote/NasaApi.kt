package com.manarelsebaay.nasademo.db.remote

import com.manarelsebaay.nasademo.db.model.MarsRoverResponse
import com.manarelsebaay.nasademo.utils.API_KEY
import com.manarelsebaay.nasademo.utils.filterTypes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApi {

    //Get filtering
    @GET("/mars-photos/api/v1/rovers/{rover}/photos?sol=1000")
    suspend fun getMarsPhotos(@Path("rover") rover: filterTypes,@Query("api_key") apikey:String): MarsRoverResponse
}