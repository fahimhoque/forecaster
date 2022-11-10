package com.example.forecaster.retrofit

import com.example.forecaster.model.datamodel.CurrentWeatherResponse
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("/forecast?city=${Constants.CITY}&appid=${Constants.API_KEY}")
    suspend fun getForecast() : Response<ForecastResponse>


    @GET("/weather?city=${Constants.CITY}&appid=${Constants.API_KEY}")
    suspend fun getWeather(): Response<CurrentWeatherResponse>
}