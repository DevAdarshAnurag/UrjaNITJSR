package com.nitjsr.urja1920.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nitjsr.urja1920.Adapters.MoreListViewAdapter;
import com.nitjsr.urja1920.Models.MoreItem;
import com.nitjsr.urja1920.R;
import com.nitjsr.urja1920.WhatsApp.EntryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    ListView listView;
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
        List<MoreItem> moreItems = new ArrayList<>();
        moreItems.add(new MoreItem("Notifications",R.mipmap.ic_launcher));
        moreItems.add(new MoreItem("Sponsors",R.mipmap.ic_launcher));
        moreItems.add(new MoreItem("Stickers",R.mipmap.ic_launcher));
        moreItems.add(new MoreItem("Maps",R.mipmap.ic_launcher_round));
        moreItems.add(new MoreItem("Share",R.mipmap.ic_launcher_round));
        moreItems.add(new MoreItem("Rate us",R.mipmap.ic_launcher_round));
        moreItems.add(new MoreItem("Website",R.mipmap.ic_launcher));
        moreItems.add(new MoreItem("Gallery",R.mipmap.ic_launcher_round));
        listView = view.findViewById(R.id.more_list_view);
        listView.setAdapter(new MoreListViewAdapter(moreItems,getContext()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2) {//stickers
                    Intent intent = new Intent(getActivity(), EntryActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
