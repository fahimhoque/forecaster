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

    @field:Json(name = "temp")
    val temp: Double?,
    @field:Json(name = "feels_like")
    val feels_like: Double?,
    @field:Json(name = "temp_min")
    val temp_min: Double?,
    @field:Json(name = "temp_max")
    val temp_max: Double?,
    @field:Json(name = "pressure")
    val pressure: Double?,
    @field:Json(name = "sea_level")
    val sea_level: Double?,
    @field:Json(name = "grnd_level")
    val grnd_level: Double?,
    @field:Json(name = "humidity")
    val humidity: Double?,
    @field:Json(name = "temp_kf")
    val temp_kf: Double?,

) : Parcelable {

    fun getTempString(): String {
        return temp.toString() + "°C"
    }

    fun getHumidityString(): String {
        return humidity.toString() + "°"
    }

    fun getTempMinString(): String {
        return temp_min.toString().substringBefore(".") + "°"
    }

    fun getTempMaxString(): String {
        return temp_max.toString().substringBefore(".") + "°"
    }
}
