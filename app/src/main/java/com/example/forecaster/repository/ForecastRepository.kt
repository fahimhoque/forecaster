package com.example.forecaster.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.retrofit.RetroServiceInterface

class ForecastRepository(private val service: RetroServiceInterface) {

    private val forecastLiveData = MutableLiveData<ForecastResponse>()
    val forecast: LiveData<ForecastResponse>
        get() = forecastLiveData

    suspend fun getForecast() {
        val result = service.getForecast()
        Log.d("result",result.toString())
        if (result.isSuccessful) {
            val items = result.body()
            Log.d("items",items.toString())
            if (items!=null){
                forecastLiveData.postValue(items!!)
            }
        }
    }
}