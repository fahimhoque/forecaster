package com.example.forecaster.repository.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.forecaster.client.RetrofitApiClient
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.repository.`interface`.ForecastInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastRepository {
    private var forecastInterface:ForecastInterface?=null

    init {
        forecastInterface = RetrofitApiClient.getApiClient().create(ForecastInterface::class.java)
    }


    fun fetchForecast(): MutableLiveData<ForecastResponse?> {
        val data = MutableLiveData<ForecastResponse?>()

        forecastInterface?.fetchForecast()?.enqueue(object : Callback<ForecastResponse> {

            override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                data.value = null
            }


            override fun onResponse(
                call: Call<ForecastResponse>,
                response: Response<ForecastResponse>
            ) {
                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data
    }
}