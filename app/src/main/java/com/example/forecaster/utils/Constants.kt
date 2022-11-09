package com.example.forecaster.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object Constants {
    const val API_KEY = "2dfe887bc005aa484dbb4d1bcb17deab"
    const val CITY = "dhaka,bd"
    const val BASE_URL_WEATHER = "https://api.openweathermap.org/data/2.5/weather?"
    const val BASE_URL_FORECAST = "https://api.openweathermap.org/data/2.5/forecast?"

    object NetworkService {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        const val API_KEY_VALUE = "2dfe887bc005aa484dbb4d1bcb17deab"
        const val RATE_LIMITER_TYPE = "data"
        const val API_KEY_QUERY = "appid"
    }

    object AlgoliaKeys {
        const val APPLICATION_ID = "plNW8IW0YOIN"
        const val SEARCH_API_KEY = "029766644cb160efa51f2a32284310eb"
    }

    object Coords {
        const val LAT = "lat"
        const val LON = "lon"
        const val METRIC = "metric"
    }
}