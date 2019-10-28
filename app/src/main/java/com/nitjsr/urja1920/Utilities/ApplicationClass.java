/*
 * Copyright (c) WhatsApp Inc. and its affiliates.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.nitjsr.urja1920.Utilities;

import android.app.Application;

import com.onesignal.OneSignal;

public class ApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //One signal work done here...
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.None)
                .setNotificationReceivedHandler(new ExampleNotificationReceivedHandler(this))
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        OneSignal.enableSound(true);
        OneSignal.enableVibrate(true);
    }
}
