package com.manarelsebaay.nasademo.presentation.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.HomeFragmentBinding
import com.manarelsebaay.nasademo.presentation.adapters.MarsPhotosAdapter
import com.manarelsebaay.nasademo.core.utils.Resource
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.domain.model.PhotoInfo
import com.manarelsebaay.nasademo.presentation.main.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment :Fragment(R.layout.home_fragment) ,View.OnClickListener{
    val TAG = "Home Fragment"
    private lateinit var binding: HomeFragmentBinding
    private  val viewModel: HomeViewModel by viewModels()
    val marsPhotosAdapter by lazy { MarsPhotosAdapter(layoutInflater,::OnItemClick) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initData()
    }

    private fun initViews() {
        binding.filters.Curiosity.setOnClickListener(this)
        binding.filters.Opportunity.setOnClickListener(this)
        binding.filters.Spirit.setOnClickListener(this)
        val marsPhotosManager: LinearLayoutManager? = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.MarsPhotosRv.layoutManager=marsPhotosManager
        binding.MarsPhotosRv.addItemDecoration(DividerItemDecoration(context, marsPhotosManager?.getOrientation() ?: 0))
        binding.MarsPhotosRv.adapter=marsPhotosAdapter }


    private fun initData() {
        viewModel.photoListState().observe(viewLifecycleOwner, { photoInfoListState -> refreshState(photoInfoListState) })
        viewModel.onLoading(viewModel.currentRover) }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.Curiosity->filter(filterTypes.Curiosity)
            R.id.Opportunity->filter(filterTypes.Opportunity)
            R.id.Spirit->filter(filterTypes.Spirit) } }

    private fun OnItemClick(id: Int, rover: String) {
        val action =HomeFragmentDirections.actionHomeFragmentToDetailsFragment(rover,id)
        view?.findNavController()?.navigate(action) }

    private fun filter(rover: filterTypes){ viewModel.onLoading(rover) }
    private fun refreshState(photoInfoListState: Resource<List<PhotoInfo>>) {
        when (photoInfoListState) {
            is Resource.Loading -> {
                binding.ProgressBar.visibility = View.VISIBLE
                marsPhotosAdapter.clear()
            }
            is Resource.Success -> {
                binding.ProgressBar.visibility = View.GONE
                marsPhotosAdapter.add(photoInfoListState.data)

                for (i in 0..photoInfoListState.data.size - 1){
//                    viewModel.savePhoto(photoInfoListState.data[i])
                }
            }
            is Resource.Error -> {
                binding.ProgressBar.visibility = View.GONE
                Toast.makeText(context, photoInfoListState.message, Toast.LENGTH_LONG).show()
            } } }



}