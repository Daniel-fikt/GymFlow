package com.example.gymflow

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(
        message: RemoteMessage
    ) {
        android.util.Log.d(
            "FCM_TEST",
            "MESSAGE RECEIVED"
        )

        val manager =
            getSystemService(
                NOTIFICATION_SERVICE
            ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel =
                NotificationChannel(
                    "gymflow_channel",
                    "GymFlow Notifications",
                    NotificationManager.IMPORTANCE_HIGH
                )

            manager.createNotificationChannel(
                channel
            )
        }

        val notification =
            NotificationCompat.Builder(
                this,
                "gymflow_channel"
            )
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(
                    message.notification?.title ?: "GymFlow"
                )
                .setContentText(
                    message.notification?.body ?: "New notification"
                )
                .setAutoCancel(true)
                .build()

        manager.notify(
            1,
            notification
        )
    }
}