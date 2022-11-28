package com.manarelsebaay.nasademo.domain.use_case.get_List_info_usecase

import com.manarelsebaay.nasademo.core.utils.DispatcherProvider
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.data.remote.dto.Photo
import com.manarelsebaay.nasademo.domain.model.PhotoInfo
import com.manarelsebaay.nasademo.domain.repository.NasaRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetPhotosListInfoUseCase @Inject constructor (
        private  val repository: NasaRepository,
        private val  dispatcherProvider:DispatcherProvider
        )
{
        @Throws(Throwable::class)
        suspend fun getPhotosListInfo(rover: filterTypes):List<PhotoInfo>{
                return withContext(dispatcherProvider.io()){
                 repository.getMarsRoverPhotos(rover.name).map { it.toPhotoInfo() }
                }
}

private fun Photo.toPhotoInfo(): PhotoInfo=

PhotoInfo(id=id,
        rover = rover.name,
        earthDate = earthDate,
        camera = camera.fullName
        )
}
