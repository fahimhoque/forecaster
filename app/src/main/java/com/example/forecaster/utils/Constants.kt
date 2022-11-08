package com.example.forecaster.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val API_KEY = "2dfe887bc005aa484dbb4d1bcb17deab"
    const val CITY = "dhaka,bd"
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_URL_FORECAST = "https://api.openweathermap.org/data/2.5/forecast?"

    @SuppressLint("SimpleDateFormat")
    fun  getDate(date: Long): String {
        val timeFormatter = SimpleDateFormat("dd.MM.yyyy")
        return timeFormatter.format(Date(date*1000L))
    }
}