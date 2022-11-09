package com.example.forecaster


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.forecaster.client.WeatherInfoClient

class MainActivity : AppCompatActivity() {

    val weather_info_client = WeatherInfoClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weather_info_client.get5Day3HourWeatherForecast()
    }

}

