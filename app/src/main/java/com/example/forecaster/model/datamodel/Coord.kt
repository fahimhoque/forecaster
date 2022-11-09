package com.example.forecaster.model.datamodel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Coord(

    @Json(name = "lon")
    val lon: Double?,

    @Json(name = "lat")
    val lat: Double?
) : Parcelable
