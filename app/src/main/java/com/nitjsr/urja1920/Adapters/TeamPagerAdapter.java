package com.nitjsr.urja1920.Adapters;

import com.nitjsr.urja1920.Fragments.BranchHeadFragment;
import com.nitjsr.urja1920.Fragments.CoreTeamFragment;
import com.nitjsr.urja1920.Fragments.SportsHeadFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TeamPagerAdapter extends FragmentPagerAdapter {
    public TeamPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        if (i == 0)
            return new CoreTeamFragment();
        if (i == 1)
            return new SportsHeadFragment();
        if (i == 2)
            return new BranchHeadFragment();
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
