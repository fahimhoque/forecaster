package com.example.forecaster.model.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.repository.data.ForecastRepository

class ForecastViewModel : ViewModel() {

    private var forecastRepository: ForecastRepository?=null
    var forecastData : MutableLiveData<ForecastResponse?>?=null

    init {
        forecastRepository = ForecastRepository()
        forecastData = MutableLiveData()
    }

    fun fetch_forecast(){
        forecastData = forecastRepository?.fetchForecast()
    }
}