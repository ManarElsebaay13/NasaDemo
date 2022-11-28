package com.manarelsebaay.nasademo.domain.repository

import androidx.lifecycle.LiveData
import com.manarelsebaay.nasademo.data.remote.dto.Photo

interface NasaRepository {

    //API
    suspend fun getMarsRoverPhotos(rover: String):List<Photo>
    // Room DB
//    suspend fun insert(item: Photo)
//    fun getAllPhotos(): LiveData<List<Photo>>
}