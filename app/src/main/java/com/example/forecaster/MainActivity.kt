package com.example.forecaster


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecaster.adapter.ListItemAdapter
import com.example.forecaster.model.datamodel.*
import com.example.forecaster.model.viewmodel.ForecastViewModel
import com.example.forecaster.model.viewmodel.ForecastViewModelFactory
import com.example.forecaster.repository.ForecastRepository
import com.example.forecaster.retrofit.RetroInstance
import com.example.forecaster.retrofit.RetroServiceInterface
import com.squareup.moshi.Json
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var forecastViewModel: ForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetroInstance.getRetroInstance().create(RetroServiceInterface::class.java)
        val repository = ForecastRepository(service)
        forecastViewModel = ViewModelProvider(this,
            ForecastViewModelFactory(repository))[ForecastViewModel::class.java]
        forecastViewModel.forecast.observe(this){
            Log.d("it",it.toString())
            var arr = ArrayList<ListItem>()
            val hs: HashSet<String> = HashSet()
            for(i in 0 until (it.list?.size ?: 0)){
                var rain = Rain(it.list?.get(i)?.rain?.jsonMember3h)
                var snow = Snow(it.list?.get(i)?.snow?.jsonMember3h)
                var main = Main(
                    it.list?.get(i)?.main?.temp,
                    it.list?.get(i)?.main?.feels_like,
                    it.list?.get(i)?.main?.temp_min,
                    it.list?.get(i)?.main?.temp_max,
                    it.list?.get(i)?.main?.pressure,
                    it.list?.get(i)?.main?.sea_level,
                    it.list?.get(i)?.main?.grnd_level,
                    it.list?.get(i)?.main?.humidity,
                    it.list?.get(i)?.main?.temp_kf,
                )
                var clouds = Clouds(it.list?.get(i)?.clouds?.all)
                var sys = Sys(it.list?.get(i)?.sys?.pod)

                var wind = Wind(it.list?.get(i)?.wind?.deg,it.list?.get(i)?.wind?.speed)
                val listItem = ListItem(it.list?.get(i)?.dt, rain, it.list?.get(i)?.dt_txt,snow,main,clouds,sys, wind)
                arr.add(listItem)
                Log.d("array in main", arr.toString())
            }
            initRecyclerView(arr)
        }
    }

    private fun initRecyclerView(arr: List<ListItem>) {
        var recyclerAdapter: ListItemAdapter
        recyclerForecast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerAdapter = ListItemAdapter(this)
        recyclerForecast.adapter =recyclerAdapter
        recyclerAdapter.setListItem(arr)
    }

}

