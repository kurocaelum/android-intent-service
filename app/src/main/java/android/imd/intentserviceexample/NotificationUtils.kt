package com.example.exemplointentservice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.imd.intentserviceexample.R
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationUtils {

    val CHANNEL_ID = "default"

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context){

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager
        val channelName = "Padrão"
        val channelDescription = "Canal padrão de notificações"
        val channel = NotificationChannel(
            CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = channelDescription
            enableLights(true)
            lightColor = Color.GREEN
            enableVibration(true)
            vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400,300, 200, 400)
        }
        notificationManager.createNotificationChannel(channel)
    }

    fun notificationSimple(context: Context){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel(context)
        }

        var notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_service)
            .setContentTitle("Serviço")
            .setContentText("Fim do Serviço")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setColor(ActivityCompat.getColor(context, R.color.colorAccent))
            .setDefaults(Notification.DEFAULT_ALL)

        var notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(1,notificationBuilder.build())

    }

}



























































