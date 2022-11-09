package com.example.forecaster.model.datamodel

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Geoloc(

    @Json(name = "lng")
    val lng: Double? = null,

    @Json(name = "lat")
    val lat: Double? = null
)
