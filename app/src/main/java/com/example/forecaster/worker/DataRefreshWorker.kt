package com.example.forecaster.worker

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.forecaster.model.viewmodel.ForecastViewModel
import com.example.forecaster.model.viewmodel.ForecastViewModelFactory
import com.example.forecaster.repository.ForecastRepository
import com.example.forecaster.retrofit.RetroInstance
import com.example.forecaster.retrofit.RetroServiceInterface

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    Worker(appContext, params) {

    private lateinit var forecastViewModel: ForecastViewModel

    companion object {
        const val TAG = "DataRefreshWorker"
    }

    override fun doWork(): Result {
        return try {
            try {
                refreshData()
                Result.success()
            } catch (e: Exception) {
                Log.d("MyWorker", "exception in doWork ${e.message}")
                Result.failure()
            }
        } catch (e: Exception) {
            Log.d("MyWorker", "exception in doWork ${e.message}")
            Result.failure()
        }
    }

    private fun refreshData(){}

}