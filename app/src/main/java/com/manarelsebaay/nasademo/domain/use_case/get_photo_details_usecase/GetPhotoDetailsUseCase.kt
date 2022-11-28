package com.manarelsebaay.nasademo.domain.use_case.get_photo_details_usecase

import com.manarelsebaay.nasademo.core.utils.DispatcherProvider
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.data.remote.dto.Photo
import com.manarelsebaay.nasademo.domain.model.PhotoDetail
import com.manarelsebaay.nasademo.domain.repository.NasaRepository
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetPhotoDetailsUseCase @Inject constructor (
    private  val repository: NasaRepository,
    private val  dispatcherProvider: DispatcherProvider
)
{
    @Throws(Throwable::class)
    suspend fun getPhotosDetailsInfo(id:Int,rover: String):PhotoDetail{
        return withContext(dispatcherProvider.io()){
            repository.getMarsRoverPhotos(rover.toString()).find{ it.id==id }?.toPhotoDetails()?: throw IOException()
        }
    }

    private fun Photo.toPhotoDetails(): PhotoDetail =
        PhotoDetail(
            rover = rover.name,
            landingDate = rover.landingDate,
            launchDate = rover.launchDate,
            imgSrc =imgSrc ,
            )
}
