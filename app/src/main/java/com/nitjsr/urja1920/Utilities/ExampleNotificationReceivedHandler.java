package com.nitjsr.urja1920.Utilities;

import com.nitjsr.urja1920.WhatsApp.StickerApplication;
import com.onesignal.OSNotification;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OneSignal;

public class ExampleNotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {
    private StickerApplication application;

    public ExampleNotificationReceivedHandler(StickerApplication stickerApplication) {
        application = stickerApplication;
    }

    @Override
    public void notificationReceived(OSNotification notification) {
        OSNotificationPayload data = notification.payload;
        String title = data.title;
        String body = data.body;
        OneSignal.clearOneSignalNotifications();
        NotificationHelper.displayNotification(application, title, body);
    }
}
