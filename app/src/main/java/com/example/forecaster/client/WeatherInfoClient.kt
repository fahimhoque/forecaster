package com.example.forecaster.client

import com.example.forecaster.utils.Constants
import java.net.URL

class WeatherInfoClient {
    // "https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API"
    fun getWeatherData(vararg params: String?): String?{
        var json_response : String?
        try{
            json_response = URL("${Constants.BASE_URL}q=${Constants.CITY}&units=metric&appid=${Constants.API_KEY}").readText(
                Charsets.UTF_8
            )
        }catch (e: Exception){
            json_response = null
        }
        return json_response
    }
}