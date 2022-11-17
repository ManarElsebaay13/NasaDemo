package com.manarelsebaay.nasademo.db.model


import com.google.gson.annotations.SerializedName

data class MarsRoverResponse(
    @SerializedName("photos")
    val photos: List<Photo>
)