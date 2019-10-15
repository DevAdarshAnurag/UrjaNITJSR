package com.nitjsr.urja1920.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nitjsr.urja1920.Adapters.CoreTeamAdapter;
import com.nitjsr.urja1920.Adapters.TabPagerAdapter;
import com.nitjsr.urja1920.Adapters.TeamPagerAdapter;
import com.nitjsr.urja1920.R;
import android.os.Bundle;
import android.widget.TableLayout;

import com.nitjsr.urja1920.Models.TeamPerson;

import java.util.ArrayList;

public class CoreTeamActivity extends AppCompatActivity {

    TabLayout coreTabLayout;
    ViewPager coreViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreteam);


        String tabNames[]={"CORE TEAM","SPORTS HEADS","BRANCH HEADS"};
        coreTabLayout = findViewById(R.id.team_tabs);
        coreViewPager = findViewById(R.id.team_tab_viewpager);
        TeamPagerAdapter tabPagerAdapter = new TeamPagerAdapter(getSupportFragmentManager());
        coreViewPager.setAdapter(tabPagerAdapter);
        coreTabLayout.setupWithViewPager(coreViewPager);
        for(int i=0;i<3;i++)
        {
            coreTabLayout.getTabAt(i).setText(tabNames[i]);
        }
        coreViewPager.setCurrentItem(1);

    }

}
