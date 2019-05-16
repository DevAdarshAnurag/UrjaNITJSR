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
import com.nitjsr.urja1920.Adapters.LeaderboardAdapter;
import com.nitjsr.urja1920.Models.Leaderboard;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaderboardFragment extends Fragment {

    DatabaseReference dbRef;
    public LeaderboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_leaderboard, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        List<Leaderboard> leaderboardList = new ArrayList();
        RecyclerView rvLeaderboard = view.findViewById(R.id.rv_leaderboard);
        rvLeaderboard.setLayoutManager(new LinearLayoutManager(getActivity()));
        LeaderboardAdapter adapter = new LeaderboardAdapter(leaderboardList);
        rvLeaderboard.setAdapter(adapter);
        dbRef = FirebaseDatabase.getInstance().getReference("Leaderboard");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                leaderboardList.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Leaderboard leaderboard = ds.getValue(Leaderboard.class);
                    leaderboardList.add(0,leaderboard);
                }
                Collections.sort(leaderboardList, new Comparator<Leaderboard>() {
                    @Override
                    public int compare(Leaderboard l1, Leaderboard l2) {
                        if(Integer.parseInt(l1.total) < Integer.parseInt(l2.total))
                            return 1;
                        else if(Integer.parseInt(l1.total) > Integer.parseInt(l2.total))
                            return -1;
                        else{
                            if(Integer.parseInt(l1.gold) < Integer.parseInt(l2.gold))
                                return 1;
                            else if(Integer.parseInt(l1.gold) > Integer.parseInt(l2.gold))
                                return -1;
                            else
                            {
                                if(Integer.parseInt(l1.silver) < Integer.parseInt(l2.silver))
                                    return 1;
                                else if(Integer.parseInt(l1.silver) > Integer.parseInt(l2.silver))
                                    return -1;
                                else
                                {
                                    if(Integer.parseInt(l1.bronze) < Integer.parseInt(l2.bronze))
                                        return 1;
                                    else
                                        return -1;
                                }
                            }
                        }
                    }
                });
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
