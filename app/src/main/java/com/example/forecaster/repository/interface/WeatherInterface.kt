package com.example.forecaster.repository.`interface`

import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface WeatherInterface {
    @GET("weather/q=${Constants.CITY}&app&units=metric&appid=${Constants.API_KEY}")
    fun fetchForecast(): Call<ForecastResponse>
}