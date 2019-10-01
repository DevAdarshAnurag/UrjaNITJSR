package com.nitjsr.urja1920.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.Adapters.UpcomingAdapter;
import com.nitjsr.urja1920.Models.Fixture;
import com.nitjsr.urja1920.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment implements UpcomingAdapter.onItemClicked {


    RecyclerView rvUpcoming;
    UpcomingAdapter adapter;
    List<Fixture> fixtureList = new ArrayList<>();
    private DatabaseReference dbRef;
    private int type = -1;
    TextView textView;

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

        String tabNames[] = {"ALL", "CRICKET", "FOOTBALL", "BASKETBALL", "VOLLEYBALL", "BADMINTON", "CHESS", "HOCKEY", "TABLE TENNIS", "ATHLETICS"};
        TabLayout tabLayout = view.findViewById(R.id.tab_upcomings);
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabNames[i]));
        }
        textView = view.findViewById(R.id.tv_upcoming);
        rvUpcoming = view.findViewById(R.id.rv_upcomings);
        rvUpcoming.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new UpcomingAdapter(getContext(), fixtureList);
        adapter.setOnClick(UpcomingFragment.this);
        rvUpcoming.setAdapter(adapter);
        fixtureFetch(fixtureList);

        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0)
                    type = -1;
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

    void fixtureFetch(List<Fixture> fixtureList) {
        dbRef = FirebaseDatabase.getInstance().getReference("Fixtures");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fixtureList.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Fixture fixture = ds.getValue(Fixture.class);
                    if (!fixture.isLive() && !fixture.isCompleted()) {
                        if (type == -1)
                            fixtureList.add(0, fixture);
                        else if (type == fixture.getType())
                            fixtureList.add(0, fixture);
                    }
                }
                sort(fixtureList);
                if(fixtureList.isEmpty())
                    textView.setVisibility(View.VISIBLE);
                else
                    textView.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    void sort(List<Fixture> fixtureList) {
        //Comparator for date
        Collections.sort(fixtureList, new Comparator<Fixture>() {
            @Override
            public int compare(Fixture f1, Fixture f2) {
                String d1 = f1.getDate();
                String d2 = f2.getDate();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa", Locale.getDefault());
                long t1 = 0, t2 = 0;
                Date mDate1 = null, mDate2 = null;
                try {
                    mDate1 = sdf.parse(d1);
                    mDate2 = sdf.parse(d2);
                    t1 = mDate1.getTime();
                    t2 = mDate2.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (t1 < t2)
                    return -1;
                else if (t1 > t2)
                    return 1;
                else
                    return 0;
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.getDefault());
        Fixture fix = fixtureList.get(position);
        String date = fix.getDate();
        long timeInMilliseconds = 0;
        Date mDate = null;
        try {
            mDate = sdf.parse(date);
            timeInMilliseconds = mDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, timeInMilliseconds)
                .putExtra(CalendarContract.Events.TITLE, fix.getmatchName(fix.getType()-1) + " " + fix.getRoundName())
                .putExtra(CalendarContract.Events.DESCRIPTION, "Urja 2020")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "NIT Jamshedpur")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        startActivity(intent);
    }
}
