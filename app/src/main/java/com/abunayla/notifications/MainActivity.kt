package com.abunayla.notifications

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        NotificationHelper().initNotificationChannel(manager)



        btn_notify.setOnClickListener{
            NotificationHelper().sendNotification(this, "Hello",
                "Test notification", R.drawable.ic_notification, NotificationCompat.PRIORITY_HIGH)

        }

    }
}