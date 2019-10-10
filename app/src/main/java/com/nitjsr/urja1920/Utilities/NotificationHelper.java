package com.nitjsr.urja1920.Utilities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.nitjsr.urja1920.Activities.HomeActivity;
import com.nitjsr.urja1920.Activities.SplashActivity;
import com.nitjsr.urja1920.R;

public class NotificationHelper {

    public static void displayNotification(Context context, String title, String body) {
        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        SharedPreferences pref = context.getApplicationContext().getSharedPreferences("MyPref", 0);
        if (pref.getBoolean(title, true)) {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, SplashActivity.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_urja)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .setDefaults(Notification.DEFAULT_SOUND);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(1, mBuilder.build());
        }
    }

}
