package com.manarelsebaay.nasademo.data.remote

import com.manarelsebaay.nasademo.data.remote.dto.MarsRoverResponse
import com.manarelsebaay.nasademo.core.utils.filterTypes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NasaApi {

    //Get filtering
    @GET("/mars-photos/api/v1/rovers/{rover}/photos?sol=1000")
    suspend fun getMarsPhotos(@Path("rover") rover: String, @Query("api_key") apikey:String): MarsRoverResponse
}