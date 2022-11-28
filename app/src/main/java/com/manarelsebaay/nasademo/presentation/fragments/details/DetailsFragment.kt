package com.manarelsebaay.nasademo.presentation.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import com.bumptech.glide.Glide
import com.flaviofaria.kenburnsview.KenBurnsView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.DetailsFragmentBinding
import com.manarelsebaay.nasademo.core.utils.Resource
import com.manarelsebaay.nasademo.domain.model.PhotoDetail
import com.manarelsebaay.nasademo.presentation.main.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment :Fragment(R.layout.details_fragment) {
    val TAG = "details Fragment"
    private lateinit var binding: DetailsFragmentBinding
    private val viewModel :DetailsViewModel by viewModels()
    val args: DetailsFragmentArgs by navArgs()


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
        onObserve()
    }
    private fun initViews() {}

    private fun onObserve() {
        viewModel.photoDetailsState().observe(viewLifecycleOwner, { photoDetailState -> refreshState(photoDetailState) })
        viewModel.onLoading(args.id, args.rover)
    }
    private fun refreshState(photoDetailState: Resource<PhotoDetail>) {
        when (photoDetailState) {
            is Resource.Loading -> binding.ProgressBar.visibility = View.VISIBLE
            is Resource.Success -> {
                binding.ProgressBar.visibility = View.GONE
                with(binding) {
                    photoDetailState.data?.let { photoDetail ->
                        binding.nameTxt.text = photoDetail.rover
                        binding.landingdateTxt.text = photoDetail.launchDate
                        binding.lanunchdateTxt.text = photoDetail.landingDate
                        binding.photo.load(photoDetail.imgSrc)
                    }
                }

            }
            is Resource.Error -> {
                binding.ProgressBar.visibility = View.GONE
                Toast.makeText(context, photoDetailState.message, Toast.LENGTH_LONG).show()
            } } }}

