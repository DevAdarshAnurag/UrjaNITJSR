package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Adapters.TabPagerAdapter;
import com.nitjsr.urja1920.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    public LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        String tabNames[]={"MATCHES","RESULTS","UPCOMING"};
        tabLayout = view.findViewById(R.id.menu_tabs);
        viewPager = view.findViewById(R.id.tab_viewpager);
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for(int i=0;i<3;i++)
        {
            tabLayout.getTabAt(i).setText(tabNames[i]);
        }
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
