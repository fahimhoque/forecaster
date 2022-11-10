package com.example.forecaster


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecaster.adapter.ListItemAdapter
import com.example.forecaster.model.datamodel.ListItem
import com.example.forecaster.model.viewmodel.ForecastViewModel
import com.example.forecaster.model.viewmodel.ForecastViewModelFactory
import com.example.forecaster.repository.ForecastRepository
import com.example.forecaster.retrofit.RetroInstance
import com.example.forecaster.retrofit.RetroServiceInterface
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
            var arr = ArrayList<ListItem>()
            val hs: HashSet<String> = HashSet()
            for(i in 0 until 7){
//                val listItem = ListItem(it.list?.get(i)?.dt,)
            }
            initRecyclerView(arr)
        }
    }

    private fun initRecyclerView(arr: List<ListItem>) {
        var recyclerAdapter: ListItemAdapter
        recyclerForecast.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = ListItemAdapter(this)
        recyclerForecast.adapter =recyclerAdapter
        recyclerAdapter.setListItem(arr)
    }

}

