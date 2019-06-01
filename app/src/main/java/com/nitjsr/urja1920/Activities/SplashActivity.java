package com.nitjsr.urja1920.Activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
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

        dbRef = FirebaseDatabase.getInstance().getReference("ready");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ready = dataSnapshot.getValue(String.class);
                if (ready.equalsIgnoreCase("yes"))
                    goHome();
                else {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(SplashActivity.this);
                    if (ready.equalsIgnoreCase("update")) {
                        builder.setTitle("Update Available");
                        builder.setMessage("Update Urja app to stay connected...");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse("https://www.google.com"));
                                startActivity(i);
                                System.gc();
                                System.exit(0);
                            }
                        });
                    } else {
                        builder.setTitle("Server Under Maintenance");
                        builder.setMessage("Please try later");
                        builder.setCancelable(false);
                        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                System.gc();
                                System.exit(0);
                            }
                        });
                    }
                    try {//do not remove try catch block
                        builder.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
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
            Thread.sleep(2500);
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
