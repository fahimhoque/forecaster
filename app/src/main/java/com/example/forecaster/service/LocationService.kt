package com.example.forecaster.service

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat

class LocationService {
//    const val REQUEST_CODE_LOCATION_PERMISSION = 100
//
//    fun getLocation(context: Context): Location? {
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) { requestPermissions(); return null }
//
//        val mLocationManager = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager
//            ?: return null
//        return mLocationManager.getLastKnownLocation(findProvider(mLocationManager) ?: "")
//    }
//
//    fun requestPermissions() {
//        ActivityCompat.requestPermissions(activity, arrayOf(ACCESS_FINE_LOCATION), REQUEST_CODE_LOCATION_PERMISSION)
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION) getWeather()
//    }
//
//    fun getWeather() {
//        getLocation()?.let { fetchWeatherData(it.latitude, it.longitude) }
//    }
}