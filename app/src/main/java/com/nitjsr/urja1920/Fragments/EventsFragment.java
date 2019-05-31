package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Adapters.EventAdapter;
import com.nitjsr.urja1920.R;
import com.nitjsr.urja1920.Models.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    int[] images = {R.drawable.athletics, R.drawable.cricket, R.drawable.badminton,R.drawable.volleyball,R.drawable.basketball,
            R.drawable.hockey,R.drawable.chess,R.drawable.table_tennis,R.drawable.splash_urja};
    RecyclerView eventRecyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        List<Events> list = new ArrayList<Events>();
        list.add(new Events("Athletics", images[0]));
        list.add(new Events("Cricket", images[1]));
        list.add(new Events("Football",images[8]));
        list.add(new Events("Badminton", images[2]));
        list.add(new Events("Volleyball",images[3]));
        list.add(new Events("Basketball",images[4]));
        list.add(new Events("Hockey",images[5]));
        list.add(new Events("Chess",images[6]));
        list.add(new Events("Table Tennis",images[7]));

        eventRecyclerView = view.findViewById(R.id.event_recycler_view);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        EventAdapter eventAdapter = new EventAdapter(getContext(), list);
        eventRecyclerView.setAdapter(eventAdapter);
        return view;
    }

}
