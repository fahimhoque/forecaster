package com.example.forecaster.model.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.repository.data.ForecastRepository

class ForecastViewModel(application: Application) : AndroidViewModel(application) {

    private var forecast_repository: ForecastRepository?=null
    var forecast_data : MutableLiveData<ForecastResponse?>?=null

    init {
        forecast_repository = ForecastRepository()
        forecast_data = MutableLiveData()
    }

    fun fetch_forecast(){
        forecast_data = forecast_repository?.fetchForecast()
    }
}