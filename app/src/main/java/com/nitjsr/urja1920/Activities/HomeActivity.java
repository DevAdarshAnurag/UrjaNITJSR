package com.nitjsr.urja1920.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.BuildConfig;
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
    private int fid = R.id.navigation_live;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            int fid2 = -1;
            switch (item.getItemId()) {
                case R.id.navigation_events:
                    fragment = new EventsFragment();
                    fid2 = R.id.navigation_events;
                    break;
                case R.id.navigation_leaderboard:
                    fragment = new LeaderboardFragment();
                    fid2 = R.id.navigation_leaderboard;
                    break;
                case R.id.navigation_live:
                    fragment = new LiveFragment();
                    fid2 = R.id.navigation_live;
                    break;
                case R.id.navigation_about_us:
                    fragment = new AboutUsFragment();
                    fid2 = R.id.navigation_about_us;
                    break;
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    fid2 = R.id.navigation_more;
                    break;
            }
            if(fid!=fid2) {
                fid = fid2;
                return loadFragment(fragment);
            }
            else {
                return true;
            }
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
        dbTask();
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

    void dbTask() {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("appurl").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String url = dataSnapshot.getValue(String.class);
                reference.child("Version").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        int version = dataSnapshot.getValue(Integer.class);
                        try {

                            if (version > BuildConfig.VERSION_CODE) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                                alertDialog.setTitle("Update your App");
                                alertDialog.setMessage("A new update is available.");
                                alertDialog.setCancelable(false);
                                alertDialog.setPositiveButton(
                                        "UPDATE",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                                intent.setData(Uri.parse(url));
                                                startActivity(intent);
                                                System.gc();
                                                System.exit(0);
                                            }
                                        });

                                alertDialog.show();
                            }
                        } catch (Exception e) {
                            //
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
