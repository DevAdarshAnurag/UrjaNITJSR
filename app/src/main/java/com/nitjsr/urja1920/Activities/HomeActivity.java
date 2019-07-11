package com.nitjsr.urja1920.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nitjsr.urja1920.Fragments.AboutUsFragment;
import com.nitjsr.urja1920.Fragments.EventsFragment;
import com.nitjsr.urja1920.Fragments.LeaderboardFragment;
import com.nitjsr.urja1920.Fragments.LiveFragment;
import com.nitjsr.urja1920.Fragments.MoreFragment;
import com.nitjsr.urja1920.R;

public class HomeActivity extends AppCompatActivity {

    boolean exit = false;
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
}
