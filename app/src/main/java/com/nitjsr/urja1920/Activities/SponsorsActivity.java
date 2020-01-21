package com.nitjsr.urja1920.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class SponsorsActivity extends AppCompatActivity {

    RelativeLayout progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        overridePendingTransition(0, 0);
        progressBar = findViewById(R.id.sponsor_progress_bar);
        ImageView sponsorImage = findViewById(R.id.iv_sponsor);
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("sponsor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = (String) dataSnapshot.getValue();
                Picasso.get().load(url).networkPolicy(NetworkPolicy.OFFLINE).into(sponsorImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        loadImage(sponsorImage,url);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadImage(ImageView sponsorImage, String url) {
        Picasso.get().load(url).into(sponsorImage, new Callback() {
            @Override
            public void onSuccess() {
                progressBar.setVisibility(View.GONE);
            }
            @Override
            public void onError(Exception e) {
                loadImage(sponsorImage,url);
            }
        });
    }
}
