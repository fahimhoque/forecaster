package com.example.forecaster.model.datamodel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

//"main": {
//    "temp": 25.78,
//    "feels_like": 25.95,
//    "temp_min": 23.35,
//    "temp_max": 25.78,
//    "pressure": 1014,
//    "sea_level": 1014,
//    "grnd_level": 1012,
//    "humidity": 59,
//    "temp_kf": 2.43
//},

@Parcelize
@JsonClass(generateAdapter = true)
data class Main(

    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "feels_like")
    val feelsLike: Double?,
    @Json(name = "temp_min")
    val tempMin: Double?,
    @Json(name = "temp_max")
    val tempMax: Double?,
    @Json(name = "pressure")
    val pressure: Double?,
    @Json(name = "sea_level")
    val seaLevel: Double?,
    @Json(name = "grnd_level")
    val grndLevel: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "temp_kf")
    val tempKf: Double?,

) : Parcelable {

    fun getTempString(): String {
        return temp.toString().substringBefore(".") + "°"
    }

    fun getHumidityString(): String {
        return humidity.toString() + "°"
    }

    fun getTempMinString(): String {
        return tempMin.toString().substringBefore(".") + "°"
    }

    fun getTempMaxString(): String {
        return tempMax.toString().substringBefore(".") + "°"
    }
}
