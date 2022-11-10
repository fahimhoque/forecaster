package com.example.forecaster.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecaster.MainActivity
import com.example.forecaster.model.datamodel.ForecastResponse
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastAdapter(val activity: Activity): RecyclerView.Adapter<ForecastAdapter.MyViewHolder>() {
    private var forecastResponse: ForecastResponse? = null


    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val timeOfTheDay = view.cardView.textViewTimeOfDay

//        fun bind(data: CountryModel, activity: Activity) {
//            tvName.text = data.name +" (" + data.species+")"
//            tvCapital.text = "Status: "+data.status
//            tvRegion.text = "Gender: "+data.gender
//            Glide.with(flagImage)
//                .load(data.image)
//                .into(flagImage)
//        }
        fun bind(data: ForecastResponse, activity: Activity){
            timeOfTheDay.text = data.cod
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        if(forecastResponse == null) return 0
        else
            return forecastResponse?.list?.size!!
    }
}