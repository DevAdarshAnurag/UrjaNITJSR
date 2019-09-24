package com.nitjsr.urja1920.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nitjsr.urja1920.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class SponsorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        overridePendingTransition(0, 0);
    }
}
