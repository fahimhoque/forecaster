package com.example.forecaster.adapter

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.forecaster.model.datamodel.CurrentWeatherResponse
import kotlinx.android.synthetic.main.layout_dashboard_forecast.view.*

class CurrentWeatherAdapter(val activity: Activity){

    private var currentWeather: CurrentWeatherResponse?=null

    fun setCurrentWeather(currentWeather: CurrentWeatherResponse){
        this.currentWeather = currentWeather
    }

    class MyViewHolder(view: View):ViewHolder(view){
        val currentTemp = view.currentWeatherViewCard.textViewTemperature
        fun bind(data: CurrentWeatherResponse, activity: Activity){
            currentTemp.text = data.main?.getTempString()
        }
    }
}