package com.nitjsr.urja1920.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nitjsr.urja1920.R;

import de.hdodenhof.circleimageview.CircleImageView;
import hari.bounceview.BounceView;

public class SponsorsActivity extends AppCompatActivity {

    CircleImageView circularImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        overridePendingTransition(0, 0);

        circularImageView = findViewById(R.id.civ1);
        BounceView.addAnimTo(circularImageView).setScaleForPopOutAnim(0f, 1f);
    }
}
