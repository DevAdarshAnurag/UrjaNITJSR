package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onActivityCreated(savedInstanceState);

        CardView civ_dev, civ_team, civ_abs;
        civ_dev = view.findViewById(R.id.cv1);
        civ_team = view.findViewById(R.id.cv2);
        civ_abs = view.findViewById(R.id.cv3);
    }

}
