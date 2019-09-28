package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nitjsr.urja1920.Adapters.EventAdapter;
import com.nitjsr.urja1920.R;
import com.nitjsr.urja1920.Models.Events;
import com.nitjsr.urja1920.Utilities.EventLayoutManager;
import com.nitjsr.urja1920.Utilities.Rules;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment implements EventAdapter.onItemClicked {

    int[] images = {R.drawable.athletics, R.drawable.cricket, R.drawable.badminton,R.drawable.volleyball,R.drawable.basketball,
            R.drawable.hockey,R.drawable.chess,R.drawable.table_tennis,R.drawable.splash_urja};
    RecyclerView eventRecyclerView;
    private EventLayoutManager eventLayoutManager;
    private BottomSheetBehavior behavior;
    private CoordinatorLayout coordinatorLayout;
    private TextView tvEventName, tvEventRules;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        NestedScrollView bottomsheet = view.findViewById(R.id.bottom_sheet);
        tvEventName = view.findViewById(R.id.event_name_);
        tvEventRules = view.findViewById(R.id.event_rules);
        coordinatorLayout = view.findViewById(R.id.coord);
        behavior = BottomSheetBehavior.from(bottomsheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        coordinatorLayout.setVisibility(View.GONE);
                        eventLayoutManager.setScrollEnabled(true);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


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
        eventLayoutManager = new EventLayoutManager(getContext());
        eventRecyclerView.setLayoutManager(eventLayoutManager);
        EventAdapter eventAdapter = new EventAdapter(getContext(),list);
        eventRecyclerView.setAdapter(eventAdapter);
        eventAdapter.setOnClick(EventsFragment.this);
    }

    @Override
    public void onItemClick(int position) {

        coordinatorLayout.setVisibility(View.VISIBLE);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        tvEventName.setText(Rules.getEventName(position));
        tvEventRules.setText(Rules.getRules(position));
        eventLayoutManager.setScrollEnabled(false);
    }
}
