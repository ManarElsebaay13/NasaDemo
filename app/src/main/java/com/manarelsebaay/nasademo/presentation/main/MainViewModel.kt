package com.manarelsebaay.nasademo.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.nasademo.db.model.Photo
import com.manarelsebaay.nasademo.db.repository.MainRepository
import com.manarelsebaay.nasademo.utils.Resource
import com.manarelsebaay.nasademo.utils.filterTypes
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel ( val repository : MainRepository): ViewModel() {

     fun photoListState(): LiveData<Resource<List<Photo>>> = photoListState
     private val photoListState: MutableLiveData<Resource<List<Photo>>> = MutableLiveData()
     var currentRover: filterTypes = filterTypes.Curiosity


    fun onLoading(rover: filterTypes) {
        currentRover = rover
        photoListState.value = Resource.Loading()
        viewModelScope.launch {
            try {
                photoListState.value = Resource.Success(repository.getMarsRoverPhotos(rover))
            } catch (e: HttpException) {
                photoListState.value = Resource.Error(e.localizedMessage ?: "An error occurred")
            } catch (e: IOException) {
                photoListState.value = Resource.Error("Check your internet connection")
            } } }

    //DB
    fun savePhoto (item: Photo)=viewModelScope.launch { repository.insert(item) }
    fun getPhotos() = repository.getAllPhotos()
}