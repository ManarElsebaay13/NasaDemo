package com.manarelsebaay.nasademo.data.repository
import com.manarelsebaay.nasademo.data.remote.dto.Photo
import com.manarelsebaay.nasademo.data.remote.NasaApi
import com.manarelsebaay.nasademo.core.utils.API_KEY
import com.manarelsebaay.nasademo.domain.repository.NasaRepository
import javax.inject.Inject


open class NasaRepositoryImpl @Inject constructor(
    private val api: NasaApi
):NasaRepository{
    override suspend fun getMarsRoverPhotos(rover: String): List<Photo> { return api.getMarsPhotos(rover, API_KEY).photos }
//    override suspend fun insert(item: Photo) =nasaDatabase.getItemsDao().insertItems(item)
//    override fun getAllPhotos()=nasaDatabase.getItemsDao().getAllitems()
}
