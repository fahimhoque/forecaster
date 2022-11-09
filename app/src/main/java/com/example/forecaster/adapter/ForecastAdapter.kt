package com.example.forecaster.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecaster.model.datamodel.ForecastResponse

class ForecastAdapter() : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>(){

    private var data : ForecastResponse?=null

    class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
    fun setData(response: ForecastResponse){
        data = response
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}