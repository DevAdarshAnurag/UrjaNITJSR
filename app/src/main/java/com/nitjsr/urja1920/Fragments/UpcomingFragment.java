package com.nitjsr.urja1920.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.Activities.HomeActivity;
import com.nitjsr.urja1920.Adapters.TabPagerAdapter;
import com.nitjsr.urja1920.Adapters.UpcomingAdapter;
import com.nitjsr.urja1920.Models.Fixture;
import com.nitjsr.urja1920.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment implements UpcomingAdapter.onItemClicked {


    private DatabaseReference dbRef;
    RecyclerView rvUpcoming;
    UpcomingAdapter adapter;
    private int type = -1;
    List<Fixture>fixtureList = new ArrayList<>();

    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        String tabNames[]={"ALL","CRICKET","FOOTBALL","BASKETBALL","VOLLEYBALL","BADMINTON","CHESS","HOCKEY","TABLE TENNIS","ATHLETICS"};
        TabLayout tabLayout = view.findViewById(R.id.tab_upcomings);
        for(int i=0;i<10;i++)
        {
            tabLayout.addTab(tabLayout.newTab().setText(tabNames[i]));
        }
        rvUpcoming = view.findViewById(R.id.rv_upcomings);
        rvUpcoming.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UpcomingAdapter(getContext(),fixtureList);
        adapter.setOnClick(UpcomingFragment.this);
        rvUpcoming.setAdapter(adapter);
        fixtureFetch(fixtureList);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()== 0)
                    type=-1;
                else
                    type = tab.getPosition();
                fixtureFetch(fixtureList);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    void fixtureFetch(List<Fixture>fixtureList)
    {
        dbRef = FirebaseDatabase.getInstance().getReference("Fixtures");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fixtureList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Fixture fixture = ds.getValue(Fixture.class);
                    if(!fixture.isLive() && !fixture.isCompleted()) {
                        if(type == -1)
                            fixtureList.add(0, fixture);
                        else if(type == fixture.getType())
                            fixtureList.add(0,fixture);
                    }
                }
                sort(fixtureList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    void sort(List<Fixture>fixtureList)
    {
        //Comparator for date
        Collections.sort(fixtureList, new Comparator<Fixture>() {
            @Override
            public int compare(Fixture f1, Fixture f2) {
                String d1 = f1.getDate();
                String d2 = f2.getDate();
                String s1[] = d1.split(" ",0);
                String s2[] = d2.split(" ",0);
                Log.d("date",s1[0]+" "+s1[1]+" "+s1[2]);
                Log.d("date",s2[0]+" "+s2[1]+" "+s2[2]);
                int day1 = Integer.parseInt(s1[0].substring(0,2));
                int day2 = Integer.parseInt(s2[0].substring(0,2));
                int month1 = Integer.parseInt(s1[0].substring(3,5));
                int month2 = Integer.parseInt(s2[0].substring(3,5));
                if(month1 < month2)
                    return 1;
                else if(month1 > month2)
                    return -1;
                else{
                    if(day1 < day2)
                        return 1;
                    else if(day1 > day2)
                        return -1;
                    else{
                        if(s1[2].charAt(0) == s2[2].charAt(0))
                        {
                            String hm1[] = s1[1].split(":",0);
                            String hm2[] = s2[1].split(":",0);
                            int h1 = Integer.parseInt(hm1[0]);
                            int h2 = Integer.parseInt(hm2[0]);
                            int m1 = Integer.parseInt(hm1[1]);
                            int m2 = Integer.parseInt(hm2[1]);
                            if(h1 < h2)
                                return 1;
                            else if(h1 > h2)
                                return -1;
                            else
                            {
                                if(m1 < m2)
                                    return 1;
                                else
                                    return -1;
                            }
                        }
                        else if(s1[2].charAt(0)=='a')
                            return 1;
                        else
                            return -1;
                    }
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/dd/MM");
        Fixture fix = fixtureList.get(position);
        String date = fix.getDate();
        date = "2020/"+date;
        long timeInMilliseconds=0;
        Date mDate = null;
        try {
            mDate = sdf.parse(date);
            timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,timeInMilliseconds)
                .putExtra(CalendarContract.Events.TITLE, fix.getRoundName())
                .putExtra(CalendarContract.Events.DESCRIPTION, fix.getTeam1()+fix.getTeam2())
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY)
                .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
        startActivity(intent);
    }
}
