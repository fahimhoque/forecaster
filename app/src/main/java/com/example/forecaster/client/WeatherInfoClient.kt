package com.example.forecaster.client

import android.util.Log
import com.example.forecaster.utils.Constants
import com.example.forecaster.model.datamodel.ForecastResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.net.URL

class WeatherInfoClient {
    fun getWeatherData(vararg params: String?): String?{
        var json_response : String?
        try{
            json_response = URL("${Constants.BASE_URL_WEATHER}q=${Constants.CITY}&units=metric&appid=${Constants.API_KEY}").readText(
                Charsets.UTF_8
            )
        }catch (e: Exception){
            json_response = null
        }
        return json_response
    }

    fun get5Day3HourWeatherForecast(vararg params: String?) : String? {
        var forecast_response: ForecastResponse?
        var json_response : String?
        try{
            json_response = URL("${Constants.BASE_URL_FORECAST}q=${Constants.CITY}&units=metric&appid=${Constants.API_KEY}").readText(
                Charsets.UTF_8
            )
        }catch (e: Exception){
            json_response = null
        }

        var moshi = Moshi.Builder().build()
        val forecast_response_adapter : JsonAdapter<ForecastResponse> = moshi.adapter(
            ForecastResponse::class.java)
        forecast_response = forecast_response_adapter.fromJson(json_response)

        Log.d("Forecast Response", forecast_response!!.toString())

        return json_response
    }
}