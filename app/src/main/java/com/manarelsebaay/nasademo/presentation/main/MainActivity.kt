package com.manarelsebaay.nasademo.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.ActivityMainBinding
import com.manarelsebaay.nasademo.db.local.NasaDatabase
import com.manarelsebaay.nasademo.db.repository.MainRepository

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nasaRepository = MainRepository(NasaDatabase(this))
        val viewModelProviderFactory = viewModelFactory(nasaRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)
    }




    
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_graph_host).navigateUp()
    }


}