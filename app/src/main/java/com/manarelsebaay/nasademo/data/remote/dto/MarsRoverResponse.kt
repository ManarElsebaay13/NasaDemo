package com.manarelsebaay.nasademo.data.remote.dto


import com.google.gson.annotations.SerializedName

data class MarsRoverResponse(
    @SerializedName("photos")
    val photos: List<Photo>
)