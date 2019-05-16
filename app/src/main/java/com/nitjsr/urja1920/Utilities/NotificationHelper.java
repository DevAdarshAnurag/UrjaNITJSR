package com.nitjsr.urja1920.Utilities;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.nitjsr.urja1920.Activities.HomeActivity;
import com.nitjsr.urja1920.Activities.SplashActivity;
import com.nitjsr.urja1920.R;

public class NotificationHelper {

    public static void displayNotification(Context context, String title, String body) {
        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, SplashActivity.CHANNEL_ID)
                .setSmallIcon(R.drawable.splash_urja)
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
