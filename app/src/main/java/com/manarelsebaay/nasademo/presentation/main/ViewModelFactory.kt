package com.manarelsebaay.nasademo.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.manarelsebaay.nasademo.db.repository.MainRepository

class viewModelFactory(
    val nasaRepository: MainRepository
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(nasaRepository) as T
    }

}
