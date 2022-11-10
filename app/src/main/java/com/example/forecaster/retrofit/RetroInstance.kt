package com.example.forecaster.retrofit

import com.example.forecaster.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}