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
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons,getContext());
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
        name.add(new TeamPerson("Swarn Pushpak",R.drawable.swarn_pushpak,"8340549608","https://www.instagram.com/pushpakjha__"));

        ArrayList<TeamPerson> name1=new ArrayList<TeamPerson>();
        name1.add(new TeamPerson("Gurdeep Singh",R.drawable.gurdeep_dagar,"8979660904","https://www.instagram.com/gurdeep_dagar001/"));


        ArrayList<TeamPerson> name2=new ArrayList<>();
        name2.add(new TeamPerson("Aditya Parihar",R.drawable.aditya_parihar,"7632013071","https://www.instagram.com/adityaparihar02"));

        ArrayList<TeamPerson> name3=new ArrayList<>();
        name3.add(new TeamPerson("Naman Kumar",R.drawable.naman_kumar,"9631835030","https://www.instagram.com/naman_shaundik"));

        ArrayList<TeamPerson> name4=new ArrayList<>();
        name4.add(new TeamPerson("Surendra Junawa",R.drawable.surendra_junawa,"8078671778","https://www.instagram.com/s_junawa"));
        name4.add(new TeamPerson("E. Rajesh",R.drawable.avatar,"#","https://www.instagram.com/"));


        ArrayList<TeamPerson> name5=new ArrayList<>();
        name5.add(new TeamPerson("Gaurav Sushil",R.drawable.gaurav_sushil,"8409223262","https://www.instagram.com/gaurav.sushil.71"));
        name5.add(new TeamPerson("Shivani Thakur",R.drawable.shivani_thakur,"7073966727,","https://www.instagram.com/_vivacious_28"));

        ArrayList<TeamPerson> name6=new ArrayList<>();
        name6.add(new TeamPerson("Sandeep",R.drawable.avatar,"9133553472","https://www.instagram.com/sandeep_sunny_036"));
        name6.add(new TeamPerson("Rahul",R.drawable.rahul_anand,"7903939288","https://www.instagram.com/rahulanand.ra28"));

        ArrayList<TeamPerson> name7=new ArrayList<>();
        name7.add(new TeamPerson("Harshit Saini",R.drawable.harshit_saini,"9471501123","https://www.instagram.com/hundred.pack.abs/"));

        ArrayList<TeamPerson> name8=new ArrayList<>();
        name8.add(new TeamPerson("Adarsh Anurag",R.drawable.adarsh_anurag,"8797834204","https://www.instagram.com/adarsh_nightmare_anurag/"));
        name8.add(new TeamPerson("Aman Kr. Srivastava",R.drawable.aman_srivastava,"7903764490","https://www.instagram.com/"));

        ArrayList<TeamPerson> name9=new ArrayList<>();
        name9.add(new TeamPerson("Sudhanshu Prakash",R.drawable.sudhanshu_prakash,"8862927236","https://www.instagram.com/d4danton"));
        name9.add(new TeamPerson("Surya Prakash",R.drawable.surya_prakash,"7004696939","https://www.instagram.com/surya__1301"));

        ArrayList<TeamPerson> name10=new ArrayList<>();

        name10.add(new TeamPerson("Mukesh Yadav",R.drawable.mukesh_kumar_yadav,"8797955195","https://www.instagram.com/"));
        name10.add(new TeamPerson("Ankit Kumar",R.drawable.ankit_kumar,"7004768402","https://www.instagram.com/ankit_agr49"));
        name10.add(new TeamPerson("Sagar Rai",R.drawable.sagar_rai,"7020402576","https://www.instagram.com/sagar_rai_21"));
        name10.add(new TeamPerson("Ravinder Meena",R.drawable.ranvinder_meena,"8076933910","https://www.instagram.com/7_delrio"));
        name10.add(new TeamPerson("Amitabh Bhardwaj",R.drawable.amitabh_bharadwaj,"8789402491","https://www.instagram.com/"));
        name10.add(new TeamPerson("Nishant Kumar",R.drawable.nishant_kumar,"6299210223","https://www.instagram.com/nishantkumar7006"));
        name10.add(new TeamPerson("Prashant Gupta",R.drawable.prashant_gupta,"7004465117","https://www.instagram.com/_just__being___me_"));
        name10.add(new TeamPerson("Mounika",R.drawable.kasu_mounika,"####","https://www.instagram.com/"));
        name10.add(new TeamPerson("Ade Mighty",R.drawable.lynn_ade_mighty,"7013979401","https://www.instagram.com/ravelmighty"));
        name10.add(new TeamPerson("Rajat Kumar Singh",R.drawable.rajat_kumar_singh,"7004048441","https://www.instagram.com/"));
        name10.add(new TeamPerson("Poonam",R.drawable.poonam,"######","https://www.instagram.com/"));
        name10.add(new TeamPerson("Rekha Kumari",R.drawable.rekha_kumari,"7488998791","https://www.instagram.com/rekkaljugani"));
        name10.add(new TeamPerson("Vipin Singh Negi",R.drawable.vipin_singh_negi,"7651928718","https://www.instagram.com/vipin_singh_negi"));
        name10.add(new TeamPerson("Rohan Sharma",R.drawable.rohan_sharma,"8804908434","https://www.instagram.com/coz.m.batman"));
        name10.add(new TeamPerson("Shubhash Chandra Munda",R.drawable.avatar,"#","https://www.instagram.com/"));
        name10.add(new TeamPerson("Abhishek Kumar",R.drawable.abhishek_kumar,"#","https://www.instagram.com/"));
        name10.add(new TeamPerson("Yash Kumar Jhanwar",R.drawable.yash_kumar_jhanwar,"9602273553","https://www.instagram.com/yash_jhanwar_yj"));
        name10.add(new TeamPerson("Amulya Toppo",R.drawable.amulya_toppo,"9771229237","https://www.instagram.com/7_dorcas"));
        name10.add(new TeamPerson("Anudeep Reddy",R.drawable.avatar,"#","https://www.instagram.com/"));

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
