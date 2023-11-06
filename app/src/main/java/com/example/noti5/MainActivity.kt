package com.example.noti5

import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.noti5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.high.setOnClickListener{
           val notification = NotificationCompat.Builder(this,App().CHANNEL_ID1)
            notification.setContentTitle(binding.title.text.toString())
            notification.setContentText(binding.content.text.toString())

           val intent = Intent(this, MainActivity::class.java)
           val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)
            notification.setSmallIcon(R.drawable.demo)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.demo,"ok",pendingIntent)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())

        }
        binding.low.setOnClickListener{
            val ACTION_SNOOZE = "snooze"
            val snoozeIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
                action = ACTION_SNOOZE
                putExtra(EXTRA_NOTIFICATION_ID, 0)
            }
            val snoozePendingIntent: PendingIntent =
                PendingIntent.getBroadcast(this, 0, snoozeIntent, PendingIntent.FLAG_IMMUTABLE)
            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.title.text.toString())
                .setContentText(binding.content.text.toString())
                .setSmallIcon(R.drawable.demo)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(snoozePendingIntent)
                .addAction(R.drawable.demo, getString(R.string.snooze),
                    snoozePendingIntent)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())

        }

        binding.image.setOnClickListener{
            val largeImageBitmap = BitmapFactory.decodeResource(resources, R.mipmap.image)
            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID3)
                .setSmallIcon(R.drawable.demo)
                .setContentTitle(binding.title.text.toString())
                .setContentText(binding.content.text.toString())
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(largeImageBitmap)
                    .bigLargeIcon(null))
                .setLargeIcon(largeImageBitmap)

            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_REMINDER)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(3,notification.build())

        }
    }
}