package com.example.forecaster.model.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.repository.ForecastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ForecastViewModel(private val forecastRepository: ForecastRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            forecastRepository.getForecast()
        }
    }

    val forecast : LiveData<ForecastResponse>
        get() {
            return forecastRepository.forecast
        }
}