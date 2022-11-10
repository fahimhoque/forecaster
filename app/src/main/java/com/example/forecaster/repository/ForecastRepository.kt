package com.example.forecaster.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.retrofit.RetroServiceInterface

class ForecastRepository(private val service: RetroServiceInterface) {

    private val characterLiveData = MutableLiveData<ForecastResponse>()
    val characters: LiveData<ForecastResponse>
        get() = characterLiveData

    suspend fun getForecast() {
        val result = service.getForecast()
        if (result.isSuccessful) {
            val items = result.body()
            if (items!=null){
                for(i in 1 until 826)
                    characterLiveData.postValue(items!!)
            }
        }
    }
}