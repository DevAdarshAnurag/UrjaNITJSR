package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nitjsr.urja1920.Adapters.ResultsAdapter;
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
public class ResultsFragment extends Fragment {

    RecyclerView rvResults;
    ResultsAdapter adapter;
    private DatabaseReference dbRef;
    private int type = -1;

    public ResultsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String tabNames[] = {"ALL", "CRICKET", "FOOTBALL", "BASKETBALL", "VOLLEYBALL", "BADMINTON", "CHESS", "HOCKEY", "TABLE TENNIS", "ATHLETICS"};
        TabLayout tabLayout = view.findViewById(R.id.tab_results);
        for (int i = 0; i < 10; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabNames[i]));
        }

        rvResults = view.findViewById(R.id.rv_results);
        List<Fixture> fixtureList = new ArrayList<>();

        rvResults.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ResultsAdapter(getContext(), fixtureList);
        rvResults.setAdapter(adapter);
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

    void sort(List<Fixture> fixtureList) {
        //Comparator for sorting
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
                    return 1;
                else if (t1 > t2)
                    return -1;
                else
                    return 0;
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
                    if (!fixture.isLive() && fixture.isCompleted()) {
                        if (type == -1)
                            fixtureList.add(0, fixture);
                        else if (type == fixture.getType())
                            fixtureList.add(0, fixture);
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
}


//                String s1[] = d1.split(" ", 0);
//                String s2[] = d2.split(" ", 0);
//                Log.d("date", s1[0] + " " + s1[1] + " " + s1[2]);
//                Log.d("date", s2[0] + " " + s2[1] + " " + s2[2]);
//                int day1 = Integer.parseInt(s1[0].substring(0, 2));
//                int day2 = Integer.parseInt(s2[0].substring(0, 2));
//                int month1 = Integer.parseInt(s1[0].substring(3, 5));
//                int month2 = Integer.parseInt(s2[0].substring(3, 5));
//                if (month1 < month2)
//                    return 1;
//                else if (month1 > month2)
//                    return -1;
//                else {
//                    if (day1 < day2)
//                        return 1;
//                    else if (day1 > day2)
//                        return -1;
//                    else {
//                        if (s1[2].charAt(0) == s2[2].charAt(0)) {
//                            String hm1[] = s1[1].split(":", 0);
//                            String hm2[] = s2[1].split(":", 0);
//                            int h1 = Integer.parseInt(hm1[0]);
//                            int h2 = Integer.parseInt(hm2[0]);
//                            int m1 = Integer.parseInt(hm1[1]);
//                            int m2 = Integer.parseInt(hm2[1]);
//                            if (h1 < h2)
//                                return 1;
//                            else if (h1 > h2)
//                                return -1;
//                            else {
//                                if (m1 < m2)
//                                    return 1;
//                                else
//                                    return -1;
//                            }
//                        } else if (s1[2].charAt(0) == 'a')
//                            return 1;
//                        else
//                            return -1;