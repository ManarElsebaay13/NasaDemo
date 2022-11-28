package com.manarelsebaay.nasademo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.nasademo.core.utils.Resource
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.domain.model.PhotoDetail
import com.manarelsebaay.nasademo.domain.use_case.get_photo_details_usecase.GetPhotoDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor ( private val getPhotoDetailsUseCase: GetPhotoDetailsUseCase): ViewModel() {

    fun photoDetailsState(): LiveData<Resource<PhotoDetail>> = photoDetailsState
    private val photoDetailsState: MutableLiveData<Resource<PhotoDetail>> = MutableLiveData()

    fun onLoading(id:Int,rover: String) {
        photoDetailsState.value = Resource.Loading()
        viewModelScope.launch {
            try {
                photoDetailsState.value = Resource.Success(getPhotoDetailsUseCase.getPhotosDetailsInfo(id,rover))
            } catch (e: HttpException) {
                photoDetailsState.value = Resource.Error(e.localizedMessage ?: "An error occurred")
            } catch (e: IOException) {
                photoDetailsState.value = Resource.Error("Check your internet connection")
            } } }
}