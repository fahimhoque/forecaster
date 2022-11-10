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
                    it.list?.get(i)?.main?.feelsLike,
                    it.list?.get(i)?.main?.tempMin,
                    it.list?.get(i)?.main?.tempMax,
                    it.list?.get(i)?.main?.pressure,
                    it.list?.get(i)?.main?.seaLevel,
                    it.list?.get(i)?.main?.grndLevel,
                    it.list?.get(i)?.main?.humidity,
                    it.list?.get(i)?.main?.tempKf,
                )
                var clouds = Clouds(it.list?.get(i)?.clouds?.all)
                var sys = Sys(it.list?.get(i)?.sys?.pod)

                var wind = Wind(it.list?.get(i)?.wind?.deg,it.list?.get(i)?.wind?.speed)
                val listItem = ListItem(it.list?.get(i)?.dt, rain, it.list?.get(i)?.dtTxt,snow,main,clouds,sys, wind)
                arr.add(listItem)
                Log.d("array in main", arr.toString())
            }
            initRecyclerView(arr)
        }
    }

    private fun initRecyclerView(arr: List<ListItem>) {
        Log.d("Recycler View", arr[0].main.toString())
        var recyclerAdapter: ListItemAdapter
        recyclerForecast.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = ListItemAdapter(this)
        recyclerForecast.adapter =recyclerAdapter
//        recyclerAdapter.setListItem(arr)
    }

}

