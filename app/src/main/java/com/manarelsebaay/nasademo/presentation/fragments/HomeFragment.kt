package com.manarelsebaay.nasademo.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.HomeFragmentBinding
import com.manarelsebaay.nasademo.adapters.MarsPhotosAdapter
import com.manarelsebaay.nasademo.db.model.Photo
import com.manarelsebaay.nasademo.utils.filterTypes
import com.manarelsebaay.nasademo.presentation.viewmodel.MainViewModel
import com.manarelsebaay.nasademo.utils.Resource

class HomeFragment :Fragment(R.layout.home_fragment) ,View.OnClickListener{
    val TAG = "Home Fragment"
    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: MainViewModel
    lateinit var marsPhotosRv:RecyclerView
    lateinit var progressBar: ProgressBar
    val marsPhotosAdapter = MarsPhotosAdapter()
    lateinit var text:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel=ViewModelProvider(this)[MainViewModel::class.java]
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }

    private fun initViews() {
        marsPhotosRv=binding.MarsPhotosRv
        progressBar=binding.ProgressBar
        binding.filters.Curiosity.setOnClickListener(this)
        binding.filters.Opportunity.setOnClickListener(this)
        binding.filters.Spirit.setOnClickListener(this)
        val marsPhotosManager: LinearLayoutManager? = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        marsPhotosRv.layoutManager=marsPhotosManager
        marsPhotosRv.adapter=marsPhotosAdapter }


    private fun initData() {
        viewModel.photoListState().observe(viewLifecycleOwner, { photoInfoListState -> refreshState(photoInfoListState) })
        viewModel.onLoading(viewModel.currentRover)
    }

    private fun filter(rover:filterTypes){ viewModel.onLoading(rover) }

    private fun refreshState(photoInfoListState: Resource<List<Photo>>) {
        when (photoInfoListState) {
            is Resource.Loading -> {
                binding.ProgressBar.visibility = View.VISIBLE
                marsPhotosAdapter.clear()
            }
            is Resource.Success -> {
                binding.ProgressBar.visibility = View.GONE
                marsPhotosAdapter.setPhotos(photoInfoListState.data)
            }
            is Resource.Error -> {
                binding.ProgressBar.visibility = View.GONE
                Toast.makeText(context, photoInfoListState.message, Toast.LENGTH_LONG).show()
            } } }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.Curiosity->filter(filterTypes.Curiosity)
            R.id.Opportunity->filter(filterTypes.Opportunity)
            R.id.Spirit->filter(filterTypes.Spirit) } }



}