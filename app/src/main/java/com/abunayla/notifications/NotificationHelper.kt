package com.abunayla.notifications
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


const val CHANNEL_ID = "notifications_channel_001"
const val CHANNEL_NAME = "notification_001"
const val NOTIFICATION_ID = 0


class NotificationHelper {

    fun initNotificationChannel(n_manager:NotificationManager){
        """ Must be called in OnCreate in an Activity"""

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }

            n_manager.createNotificationChannel(channel)

        }

    }

    fun sendNotification(context: Context, title:String, text:String, icon: Int,
                                priority:Int){
"""Can be called after initNotificationChannel() as needed"""
        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(icon)
            .setPriority(priority)
            .build()

        val notificationManagerCompact = NotificationManagerCompat.from(context)
        notificationManagerCompact.notify(NOTIFICATION_ID, notification )

    }
}