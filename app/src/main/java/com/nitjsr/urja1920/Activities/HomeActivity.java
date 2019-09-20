package com.nitjsr.urja1920.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.Fragments.AboutUsFragment;
import com.nitjsr.urja1920.Fragments.EventsFragment;
import com.nitjsr.urja1920.Fragments.LeaderboardFragment;
import com.nitjsr.urja1920.Fragments.LiveFragment;
import com.nitjsr.urja1920.Fragments.MoreFragment;
import com.nitjsr.urja1920.R;

public class HomeActivity extends AppCompatActivity {

    boolean exit = false;
    private DatabaseReference dbRef;
    private String ready = "";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    fragment = new EventsFragment();
                    break;
                case R.id.navigation_leaderboard:
                    fragment = new LeaderboardFragment();
                    break;
                case R.id.navigation_live:
                    fragment = new LiveFragment();
                    break;
                case R.id.navigation_about_us:
                    fragment = new AboutUsFragment();
                    break;
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        overridePendingTransition(0, 0);
        loadFragment(new LiveFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_live);
        dbCheck();
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            System.gc();
            System.exit(0);
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);
        }
    }

    private void dbCheck() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        dbRef = firebaseDatabase.getReference("ready");
        dbRef.keepSynced(true);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ready = dataSnapshot.getValue(String.class);
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(HomeActivity.this);
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
                } else if(ready.equalsIgnoreCase("maintenance")){
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

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
