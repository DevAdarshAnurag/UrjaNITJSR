package com.nitjsr.urja1920.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
