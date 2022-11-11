package com.example.forecaster.model.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecaster.model.datamodel.CurrentWeatherResponse
import com.example.forecaster.repository.CurrentWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrentViewModel(private val currentWeatherRepository: CurrentWeatherRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            currentWeatherRepository.getCurrentWeather()
        }
    }

    val weather: LiveData<CurrentWeatherResponse>
        get() {
            return currentWeatherRepository.weather
        }
}