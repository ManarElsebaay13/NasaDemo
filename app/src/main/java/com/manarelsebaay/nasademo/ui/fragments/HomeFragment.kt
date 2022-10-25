package com.manarelsebaay.nasademo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.HomeFragmentBinding

class HomeFragment :Fragment(R.layout.home_fragment) {

    val TAG = "Home Fragment"
    private lateinit var binding: HomeFragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}