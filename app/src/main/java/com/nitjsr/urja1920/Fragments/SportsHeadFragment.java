package com.nitjsr.urja1920.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Adapters.CoreTeamAdapter;
import com.nitjsr.urja1920.Models.TeamPerson;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SportsHeadFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> posts;
    ArrayList<ArrayList<TeamPerson>> persons;


    public SportsHeadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports_head, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        posts=new ArrayList<String>();
        persons=new ArrayList<ArrayList<TeamPerson>>();
        fillData();
        recyclerView=view.findViewById(R.id.sports_head_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons);
        recyclerView.setAdapter(coreTeamAdapter);
    }


    public  void fillData()
    {
        posts.add("Volleyball");
        posts.add("Basketball");
        posts.add("Hockey");
        posts.add("Athletics");
        posts.add("Badminton");
        posts.add("Table Tennis");
        posts.add("Cricket");
        posts.add("Chess");
        posts.add("Football");

        ArrayList<TeamPerson> name=new ArrayList<TeamPerson>();
        name.add(new TeamPerson("Raja Kumar Singh Sinha Rajput",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));


        ArrayList<TeamPerson> name1=new ArrayList<TeamPerson>();
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));


        ArrayList<TeamPerson> name3=new ArrayList<>();
        name3.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name3.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        persons.add(name3);
        persons.add(name1);
        persons.add(name);
    }

}
