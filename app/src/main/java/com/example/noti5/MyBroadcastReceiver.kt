package com.example.noti5

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import androidx.core.app.NotificationCompat

class MyBroadcastReceiver:BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            val notificationId = intent.getIntExtra("notification_id", 0)

            val snoozeNotification = NotificationCompat.Builder(context, App().CHANNEL_ID3)
                .setSmallIcon(R.drawable.demo)
                .setContentTitle("Snoozed Notification")
                .setContentText("This notification was snoozed.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build()

            val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(notificationId,snoozeNotification)

        }
    }
