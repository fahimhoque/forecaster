package com.example.forecaster.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecaster.model.datamodel.CurrentWeatherResponse
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.retrofit.RetroServiceInterface

class CurrentWeatherRepository(private val service: RetroServiceInterface) {

    private val currentWeatherLiveData = MutableLiveData<CurrentWeatherResponse>()
    val weather: LiveData<CurrentWeatherResponse>
        get() = currentWeatherLiveData

    suspend fun getCurrentWeather() {
        val result = service.getWeather()
        Log.d("result",result.toString())
        if (result.isSuccessful) {
            val items = result.body()
            Log.d("items",items.toString())
            if (items!=null){
                currentWeatherLiveData.postValue(items!!)
            }
        }
    }
}