package com.example.forecaster.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RainNotificationService(val context: Context, workerParameters: WorkerParameters):
    Worker(context, workerParameters) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}