package com.example.forecaster


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.forecaster.model.viewmodel.ForecastViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var vm:ForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this)[ForecastViewModel::class.java]
    }

}

