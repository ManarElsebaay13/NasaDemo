package com.manarelsebaay.nasademo.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.MarsPhotosItemBinding
import com.manarelsebaay.nasademo.core.utils.filterTypes
import com.manarelsebaay.nasademo.data.remote.dto.Photo
import com.manarelsebaay.nasademo.data.remote.dto.Rover
import com.manarelsebaay.nasademo.domain.model.PhotoInfo


class MarsPhotosAdapter(
    private val layoutInflater: LayoutInflater,
    private val onItemClick: (id: Int, rover: String) -> Unit
): RecyclerView.Adapter<PhotoDetailsViewHolder>() {
    private var MarsPhotosList = mutableListOf<PhotoInfo>()
    lateinit var context: Context

    override fun getItemCount(): Int =MarsPhotosList.size
    override fun onBindViewHolder(holder: PhotoDetailsViewHolder, position: Int) =holder.bind(MarsPhotosList[position])
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDetailsViewHolder = PhotoDetailsViewHolder(layoutInflater,parent,onItemClick)

    fun clear() {
        this.MarsPhotosList.clear()
        notifyDataSetChanged() }

    fun add(weatherList: List<PhotoInfo>) {
        this.MarsPhotosList.addAll(weatherList)
        notifyDataSetChanged() }
}

class PhotoDetailsViewHolder(
    layoutInflater: LayoutInflater,
    parentView: ViewGroup,
    private val onItemClick:(id:Int,rover:String) -> Unit
) : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.mars_photos_item,parentView,false)) {

    private val roverTextView: TextView = itemView.findViewById(R.id.rover_txt)
    private val earthDateTextView: TextView = itemView.findViewById(R.id.date_txt)
    private val cameraValue: TextView = itemView.findViewById(R.id.camera_txt)

    fun bind(itemInfo:PhotoInfo){
        itemView.setOnClickListener{ onItemClick(itemInfo.id,itemInfo.rover)}
        roverTextView.text = itemInfo.rover
        earthDateTextView.text = itemInfo.earthDate
        cameraValue.text = itemInfo.camera

    }


}