package com.example.forecaster.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    Worker(appContext, params) {

    companion object {
        const val TAG = "DataRefreshWorker"
    }

    override fun doWork(): Result {
        TODO("Not yet implemented")
    }

}