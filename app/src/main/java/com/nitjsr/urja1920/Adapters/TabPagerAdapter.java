package com.nitjsr.urja1920.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nitjsr.urja1920.Fragments.OngoingFragment;
import com.nitjsr.urja1920.Fragments.ResultsFragment;
import com.nitjsr.urja1920.Fragments.UpcomingFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0)
            return new OngoingFragment();
        if (i == 1)
            return new ResultsFragment();
        if (i == 2)
            return new UpcomingFragment();
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
