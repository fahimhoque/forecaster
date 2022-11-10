package com.example.forecaster.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.forecaster.R
import com.example.forecaster.model.datamodel.ForecastResponse
import com.example.forecaster.model.datamodel.ListItem
import kotlinx.android.synthetic.main.item_forecast.view.*

class ListItemAdapter(val activity: Activity): RecyclerView.Adapter<ListItemAdapter.MyViewHolder>() {
    private var forecastResponse: ForecastResponse? = null
    private var listItems: List<ListItem>?=null

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val timeOfTheDay = view.cardView.textViewTimeOfDay
        fun bind(data: ListItem, activity: Activity){
            Log.d("data", data.toString())
            timeOfTheDay.text = data.getDay()
        }
    }
    fun setListItem(listItems: List<ListItem>){
        this.listItems = listItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemAdapter.MyViewHolder, position: Int) {
        holder.bind(forecastResponse!!.list!![position], activity)
    }

    override fun getItemCount(): Int {
        return if(listItems == null) 0
        else
            Log.d("ItemSize", listItems?.size.toString())
            listItems?.size!!
    }
}