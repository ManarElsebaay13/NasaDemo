package com.manarelsebaay.nasademo.data.remote.dto


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(
    tableName = "NasaEntity"
)
data class Photo(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("camera")
    val camera: Camera,
    @SerializedName("earth_date")
    val earthDate: String,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("rover")
    val rover: Rover,
    @SerializedName("sol")
    val sol: Int
)