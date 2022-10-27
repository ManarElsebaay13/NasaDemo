package com.manarelsebaay.nasademo.db.repository

import com.manarelsebaay.nasademo.db.local.NasaDatabase
import com.manarelsebaay.nasademo.db.model.Photo
import com.manarelsebaay.nasademo.db.remote.NasaApi
import com.manarelsebaay.nasademo.db.remote.RetrofitClient
import com.manarelsebaay.nasademo.utils.API_KEY
import com.manarelsebaay.nasademo.utils.filterTypes


open class MainRepository (val nasaDatabase: NasaDatabase){

    //API
    suspend fun getMarsRoverPhotos(rover:filterTypes):List<Photo>{
        val  client= RetrofitClient.getInstance().create(NasaApi::class.java).getMarsPhotos(rover, API_KEY)
        return client?.photos!! }

    // Room DB
    suspend fun insert(item: Photo)=nasaDatabase.getItemsDao().insertItems(item)
    fun getAllPhotos()=nasaDatabase.getItemsDao().getAllitems()


}