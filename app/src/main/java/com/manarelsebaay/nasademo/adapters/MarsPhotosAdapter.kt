package com.manarelsebaay.nasademo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.manarelsebaay.nasa_demo.R
import com.manarelsebaay.nasa_demo.databinding.MarsPhotosItemBinding
import com.manarelsebaay.nasademo.db.model.Photo


class MarsPhotosAdapter(): RecyclerView.Adapter<MarsPhotosAdapter.Holder>() {

    private var MarsPhotosList = mutableListOf<Photo>()
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context=parent.context
        return Holder(
            LayoutInflater.from(context).inflate(R.layout.mars_photos_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val photo= MarsPhotosList?.get(position)
        holder.rover.text= "Rover : ${photo?.rover?.name.toString()}"
        holder.camera.text= "Camera : ${photo?.camera?.fullName.toString()}"
        holder.date.text="Date : ${photo?.earthDate.toString()}"
        holder.itemView.setOnClickListener {
            var bundle = bundleOf("photoPath" to "${photo?.imgSrc}")
            bundle.putString("name", photo?.rover?.name!!)
            bundle.putString("launch", photo?.rover?.launchDate!!)
            bundle.putString("land", photo?.rover?.landingDate!!)
            it.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment , bundle,null, null) }
    }

    override fun getItemCount(): Int { return MarsPhotosList?.size ?: 0 }

    class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding= MarsPhotosItemBinding.bind(itemView)
        val rover= binding.roverTxt
        val camera=binding.cameraTxt
        val date =binding.dateTxt
    }

    fun setPhotos(photo: List<Photo>){
        this.MarsPhotosList.addAll(photo)
        notifyDataSetChanged() }

    fun clear() {
        this.MarsPhotosList.clear()
        notifyDataSetChanged() }
}