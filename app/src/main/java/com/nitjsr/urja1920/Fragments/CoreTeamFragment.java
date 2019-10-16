package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Adapters.CoreTeamAdapter;
import com.nitjsr.urja1920.Models.TeamPerson;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoreTeamFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> posts;
    ArrayList<ArrayList<TeamPerson>> persons;

    public CoreTeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_core_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        posts=new ArrayList<String>();
        persons=new ArrayList<ArrayList<TeamPerson>>();
        fillData();
        recyclerView=view.findViewById(R.id.core_team_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons);
        recyclerView.setAdapter(coreTeamAdapter);
    }

    public  void fillData()
    {
        posts.add("Sports Secretary");
        posts.add("Joint Sports Secretary");
        posts.add("General Secretary");
        posts.add("Joint Secretary");
        posts.add("Executive Secretary");
        posts.add("Event Head");
        posts.add("Medical Head");
        posts.add("PR Head");
        posts.add("App Head");
        posts.add("Creative Head");
        posts.add("Core Members");

        ArrayList<TeamPerson> name=new ArrayList<TeamPerson>();
        name.add(new TeamPerson("Swarn Pushpak",R.drawable.avatar,"8340549608","https://www.instagram.com/pushpakjha___"));

        ArrayList<TeamPerson> name1=new ArrayList<TeamPerson>();
        name1.add(new TeamPerson("Gurdeep Singh",R.drawable.avatar,"8979660904","https://www.instagram.com/gurdeep_dagar001/"));


        ArrayList<TeamPerson> name2=new ArrayList<>();
        name2.add(new TeamPerson("Aditya Parihar",R.drawable.avatar,"#","https://www.instagram.com/"));

        ArrayList<TeamPerson> name3=new ArrayList<>();
        name3.add(new TeamPerson("Naman Kumar",R.drawable.avatar,"#","https://www.instagram.com/"));

        ArrayList<TeamPerson> name4=new ArrayList<>();
        name4.add(new TeamPerson("Aditya Parihar",R.drawable.avatar,"#","https://www.instagram.com/"));


        ArrayList<TeamPerson> name5=new ArrayList<>();
        name5.add(new TeamPerson("Surendra Junawa",R.drawable.avatar,"#","https://www.instagram.com/"));
        name5.add(new TeamPerson("E. Rajesh",R.drawable.avatar,"#","https://www/instagram.com/"));

        ArrayList<TeamPerson> name6=new ArrayList<>();
        name6.add(new TeamPerson("Sandeep",R.drawable.avatar,"#","https://www.instagram.com/"));
        name6.add(new TeamPerson("Rahul",R.drawable.avatar,"#","https://www/instagram.com/"));

        ArrayList<TeamPerson> name7=new ArrayList<>();
        name7.add(new TeamPerson("Harshit Saini",R.drawable.avatar,"#","https://www.instagram.com/hundred.pac.abs/"));

        ArrayList<TeamPerson> name8=new ArrayList<>();
        name8.add(new TeamPerson("Adarsh Anurag",R.drawable.avatar,"#","https://www.instagram.com/adarsh_nightmare_anurag/"));
        name8.add(new TeamPerson("Aman Kr. Srivastava",R.drawable.avatar,"#","https://www/instagram.com/"));

        ArrayList<TeamPerson> name9=new ArrayList<>();
        name9.add(new TeamPerson("Sudhanshu Prakash",R.drawable.avatar,"#","https://www.instagram.com/"));
        name9.add(new TeamPerson("Surya Prakash",R.drawable.avatar,"#","https://www/instagram.com/"));

        ArrayList<TeamPerson> name10=new ArrayList<>();
        name10.add(new TeamPerson("Mukesh Yadav",R.drawable.avatar,"#","https://www.instagram.com/"));


        persons.add(name);
        persons.add(name1);
        persons.add(name2);
        persons.add(name3);
        persons.add(name4);
        persons.add(name5);
        persons.add(name6);
        persons.add(name7);
        persons.add(name8);
        persons.add(name9);
        persons.add(name10);
    }
}
