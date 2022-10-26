package com.manarelsebaay.nasademo.repository

import com.manarelsebaay.nasademo.db.model.Photo
import com.manarelsebaay.nasademo.db.remote.NasaApi
import com.manarelsebaay.nasademo.db.remote.RetrofitClient
import com.manarelsebaay.nasademo.utils.API_KEY


class MainRepository {

    suspend fun getMarsPhotos():List<Photo>{
        val client=RetrofitClient.getInstance().create(NasaApi::class.java).getPhotos(1, API_KEY)
        return client?.photos!!
    }

    suspend fun getMarsRoverPhotos():List<Photo>{
        val  client= RetrofitClient.getInstance().create(NasaApi::class.java).getMarsPhotos("Spirit",1,API_KEY)
        return client?.photos!!
    }

}