package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.nitjsr.urja1920.Adapters.OngoingAdapter;
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
public class OngoingFragment extends Fragment {

    RecyclerView rvMatchesLive;
    OngoingAdapter adapter;
    private DatabaseReference dbRef;

    public OngoingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ongoing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rvMatchesLive = view.findViewById(R.id.rv_matxhes_live);
        List<Fixture> fixtureList = new ArrayList<>();

        rvMatchesLive.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new OngoingAdapter(getContext(), fixtureList);
        rvMatchesLive.setAdapter(adapter);
        fixtureFetch(fixtureList);
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
                    return -1;
                else if (t1 > t2)
                    return 1;
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
                    if (fixture.isLive() && !fixture.isCompleted()) {
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
