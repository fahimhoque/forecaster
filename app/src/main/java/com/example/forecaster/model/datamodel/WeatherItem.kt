package com.example.forecaster.model.datamodel

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class WeatherItem(

    @Json(name = "icon")
    val icon: String?,

    @Json(name = "description")
    val description: String?,

    @Json(name = "main")
    val main: String?,

    @Json(name = "id")
    val id: Int?
) : Parcelable {

    fun getDescriptionText(): String? {
        return description?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}
