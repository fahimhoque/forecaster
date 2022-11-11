package com.example.forecaster.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.forecaster.R

private const val TAG = "WorkerUtils"
fun makeStatusNotification(message: String, context: Context){
    // Make a channel if necessary
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "DATA_REFRESH_CHANNEL"
        val description = "DATA_REFRESH_CHANNEL_DESC"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("CHANNEL_ID_REFRESH_DATA", name, importance)
        channel.description = description

        // Add the channel
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.createNotificationChannel(channel)
    }

    // Create the notification
    val builder = NotificationCompat.Builder(context, "CHANNEL_ID_REFRESH_DATA")
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("New Data Fetched")
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))

    // Show the notification
    NotificationManagerCompat.from(context).notify(1, builder.build())
}