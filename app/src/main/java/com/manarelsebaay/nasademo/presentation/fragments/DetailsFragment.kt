package com.manarelsebaay.nasademo.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.flaviofaria.kenburnsview.KenBurnsView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.DetailsFragmentBinding

class DetailsFragment :Fragment(R.layout.details_fragment) {

    val TAG = "details Fragment"
    private lateinit var binding: DetailsFragmentBinding
    lateinit var marsPhoto:KenBurnsView
    lateinit var nametxt:TextView
    lateinit var launchtxt:TextView
    lateinit var landtxt:TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }
    private fun initViews() {
        marsPhoto=binding.photo
        nametxt=binding.nameTxt
        launchtxt=binding.lanunchdateTxt
        landtxt=binding.landingdateTxt }

    private fun initData() {
        var photoPath = arguments?.get("photoPath").toString()
        var name = arguments?.getString("name")!!
        var launch = arguments?.getString("launch")!!
        var land = arguments?.getString("land")!!
        Glide.with(this).load("${photoPath}").into(marsPhoto)
        nametxt.text="Rover : ${name}"
        launchtxt.text="LaunchDate : ${launch}"
        landtxt.text="LandDate : ${land}" } }