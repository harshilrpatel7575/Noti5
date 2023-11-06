package com.example.noti5

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class App: Application() {
    val CHANNEL_ID1 = "CHANNEL_ID1"
    val CHANNEL_ID2 = "CHANNEL_ID2"
    val CHANNEL_ID3 = "CHANNEL_ID3"
    override fun onCreate() {
        super.onCreate()

        val channel1 = NotificationChannel(CHANNEL_ID1,"Channel 1", NotificationManager.IMPORTANCE_HIGH )
        channel1.description="this my high important channel for notification"
        val channel2 = NotificationChannel(CHANNEL_ID2,"Channel 2", NotificationManager.IMPORTANCE_DEFAULT )
        channel2.description="this my default important channel for notification"
        val channel3 = NotificationChannel(CHANNEL_ID3,"channel 3", NotificationManager.IMPORTANCE_HIGH)
        channel3.description=="this my default important channel for notification"

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        manager.createNotificationChannel(channel1)
        manager.createNotificationChannel(channel2)
        manager.createNotificationChannel(channel3)
    }
}