package com.manarelsebaay.nasademo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.nasademo.core.utils.Resource
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.domain.model.PhotoInfo
import com.manarelsebaay.nasademo.domain.use_case.get_List_info_usecase.GetPhotosListInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor ( private val getPhotosListInfoUseCase: GetPhotosListInfoUseCase): ViewModel() {

     fun photoListState(): LiveData<Resource<List<PhotoInfo>>> = photoListState
     private val photoListState: MutableLiveData<Resource<List<PhotoInfo>>> = MutableLiveData()
     var currentRover: filterTypes = filterTypes.Curiosity


    fun onLoading(rover: filterTypes) {
        currentRover = rover
        photoListState.value = Resource.Loading()
        viewModelScope.launch {
            try {
                photoListState.value = Resource.Success(getPhotosListInfoUseCase.getPhotosListInfo(rover))
            } catch (e: HttpException) {
                photoListState.value = Resource.Error(e.localizedMessage ?: "An error occurred")
            } catch (e: IOException) {
                photoListState.value = Resource.Error("Check your internet connection")
            } } }

//    //DB
//    fun savePhoto (item: Photo)=viewModelScope.launch { repository.insert(item) }
//    fun getPhotos() = repository.getAllPhotos()
}