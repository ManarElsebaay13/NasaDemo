package com.manarelsebaay.nasademo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.nasademo.db.model.Photo
import com.manarelsebaay.nasademo.repository.MainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel :ViewModel() {

       val repository =MainRepository()
       var MarsPhotosList = MutableLiveData<List<Photo>>()
       var RoverPhotosList = MutableLiveData<List<Photo>>()


    init {
        getMarsPhotosList()
        getRoverPhotosList()
    }

    private fun getMarsPhotosList() {
        viewModelScope.launch(IO){
            var Marslist= repository.getMarsPhotos()
            withContext(Main){
                MarsPhotosList.postValue(Marslist!!)
                println("mmmmmmmmmmMars+${Marslist.toString()}")
            }
        }    }

    fun getRoverPhotosList() {
        viewModelScope.launch(IO){
            var roverlist= repository.getMarsRoverPhotos()
            withContext(Main){
                RoverPhotosList.postValue(roverlist!!)
                println("mmmmmmmmmmRover+${roverlist.toString()}")
            }
        }}


}