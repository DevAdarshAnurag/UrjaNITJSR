package com.nitjsr.urja1920.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Activities.MapActivity;
import com.nitjsr.urja1920.Activities.NotificationSettingsActivity;
import com.nitjsr.urja1920.Activities.SponsorsActivity;
import com.nitjsr.urja1920.R;
import com.nitjsr.urja1920.WhatsApp.EntryActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {

    CardView cv1, cv2, cv3, cv4, cv5, cv6;

    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        cv1 = view.findViewById(R.id.sponsors);
        cv2 = view.findViewById(R.id.notify);
        cv3 = view.findViewById(R.id.maps);
        cv4 = view.findViewById(R.id.stickers);
        cv5 = view.findViewById(R.id.rate);
        cv6 = view.findViewById(R.id.share);
        cv1.setOnClickListener(this);
        cv2.setOnClickListener(this);
        cv3.setOnClickListener(this);
        cv4.setOnClickListener(this);
        cv5.setOnClickListener(this);
        cv6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sponsors) {
            Intent intent = new Intent(getActivity(), SponsorsActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.notify) {
            Intent intent = new Intent(getActivity(), NotificationSettingsActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.maps) {
            Intent intent = new Intent(getActivity(), MapActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.stickers) {
            Intent intent = new Intent(getActivity(), EntryActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.share) {

        } else if (v.getId() == R.id.rate) {

        }
    }
}
