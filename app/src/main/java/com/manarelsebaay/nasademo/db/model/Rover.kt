package com.manarelsebaay.nasademo.db.model


import com.google.gson.annotations.SerializedName

data class Rover(
    @SerializedName("id")
    val id: String,
    @SerializedName("landing_date")
    val landingDate: String,
    @SerializedName("launch_date")
    val launchDate: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String
)