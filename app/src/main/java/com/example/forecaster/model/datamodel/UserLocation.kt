package com.example.forecaster.model.datamodel

import java.io.Serializable

data class UserLocation(
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
) : Serializable