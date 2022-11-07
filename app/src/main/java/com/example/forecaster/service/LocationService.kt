package com.example.forecaster.service

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

//class LocationService {
//    private val PERMISSION_ID = 42
//
//    private fun requestPermissions() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
//            PERMISSION_ID
//        )
//    }
//
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
//        if (requestCode == PERMISSION_ID) {
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                getLastLocation()
//            }
//        }
//    }
//}