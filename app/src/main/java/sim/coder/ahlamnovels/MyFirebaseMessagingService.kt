package sim.coder.ahlamnovels

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    lateinit var notificatinManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    val channelId="sim.coder.lists"
    val description="My Notification"



    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")

            if (true) {

                scheduleJob()
            } else {

                handleNow()
            }
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
        }


    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        sendRegistrationToServer(token)
    }


    private fun scheduleJob() {
    }


    private fun handleNow() {
        Log.d(TAG, "Short lived task is done.")
    }


    private fun sendRegistrationToServer(token: String?) {
        // TODO: Implement this method to send token to your app server.
        Log.d(TAG, "sendRegistrationTokenToServer($token)")
    }


    private fun sendNotification(messageBody: String) {

        val intent= Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,intent,
            PendingIntent.FLAG_UPDATE_CURRENT)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel=NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.lightColor= Color.YELLOW
            notificationChannel.enableLights(true)
            notificationChannel.enableVibration(true)
            notificatinManager.createNotificationChannel(notificationChannel)
            val builder= Notification.Builder(this,channelId)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

            notificatinManager.notify(0,builder.build())

        }

    }

    companion object {

        private const val TAG = "MyFirebaseMsgService"
    }
}