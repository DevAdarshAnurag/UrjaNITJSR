package com.nitjsr.urja1920.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.R;

public class SplashActivity extends AppCompatActivity {

    public static final String CHANNEL_ID = "Urja1920";
    private DatabaseReference dbRef;
    private String ready = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        createNotificationChannel();
        goHome();
        overridePendingTransition(R.anim.magic, 0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //for hiding screen navigation buttons and show them when required by user; providing immersive display
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        }
    }

    private void goHome() {
        new Thread(new Runnable() {
            public void run() {
                doWork();
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }).start();
    }

    private void doWork() {
        try {
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
            if(!pref.getBoolean("First",false)) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("Notify", true);
                editor.putBoolean("Athletics", true);
                editor.putBoolean("Cricket", true);
                editor.putBoolean("Football", true);
                editor.putBoolean("Basketball", true);
                editor.putBoolean("Volleyball", true);
                editor.putBoolean("Hockey", true);
                editor.putBoolean("Chess", true);
                editor.putBoolean("Badminton", true);
                editor.putBoolean("Table Tennis", true);
                editor.putBoolean("First",true);
                editor.apply();
            }
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "Urja";
            String description = "Urja, athletics and sports meet of NITJSR";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}
