package com.manarelsebaay.nasademo.data.remote

import com.manarelsebaay.nasademo.core.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object {
        private var INSTANCE: Retrofit? = null
        fun getInstance(): Retrofit {
            if (INSTANCE == null) {
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE!!
        }
    }
}
