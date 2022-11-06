package com.example.forecaster.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Contants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_URL_FORECAST = "https://api.openweathermap.org/data/2.5/forecast?"
    const val OPEN_WEATHER_API_KEY = "d9abb2c1d05c5882e937cffd1ecd4923"

    @SuppressLint("SimpleDateFormat")
    fun  getDate(date: Long): String {
        val timeFormatter = SimpleDateFormat("dd.MM.yyyy")
        return timeFormatter.format(Date(date*1000L))
    }
}