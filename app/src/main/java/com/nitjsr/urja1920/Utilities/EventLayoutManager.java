package com.nitjsr.urja1920.Utilities;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

public class EventLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;
    public EventLayoutManager(Context context) {
        super(context);
    }
    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}

