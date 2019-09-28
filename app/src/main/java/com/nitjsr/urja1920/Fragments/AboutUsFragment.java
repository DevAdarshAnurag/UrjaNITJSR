package com.nitjsr.urja1920.Fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.nitjsr.urja1920.Activities.CoreTeamActivity;
import com.nitjsr.urja1920.Activities.DevelopersActivity;
import com.nitjsr.urja1920.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {

    CardView civ_dev, civ_team, civ_abs;

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


        civ_dev = view.findViewById(R.id.cv1);
        civ_team = view.findViewById(R.id.cv2);
        civ_abs = view.findViewById(R.id.cv3);
        civ_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CoreTeamActivity.class));
            }
        });

        civ_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DevelopersActivity.class));
            }
        });
        applyAnimation();
    }

    private void applyAnimation() {
        Animation animZoomOut = AnimationUtils.loadAnimation(getContext(),R.anim.zoom_out);
        civ_abs.startAnimation(animZoomOut);
        civ_dev.startAnimation(animZoomOut);
        civ_team.startAnimation(animZoomOut);
    }

}
