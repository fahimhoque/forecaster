package com.example.forecaster.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forecaster.repository.CurrentWeatherRepository
import com.example.forecaster.repository.ForecastRepository

class CurrentViewModelFactory(private val repository: CurrentWeatherRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CurrentViewModel(repository) as T
    }
}