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
public class BranchHeadFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> posts;
    ArrayList<ArrayList<TeamPerson>> persons;


    public BranchHeadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_branch_head, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        posts=new ArrayList<String>();
        persons=new ArrayList<ArrayList<TeamPerson>>();
        fillData();
        recyclerView=view.findViewById(R.id.branch_head_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons,getContext());
        recyclerView.setAdapter(coreTeamAdapter);
    }

    public  void fillData()
    {
        posts.add("CSE HEAD");
        posts.add("ECE HEAD");
        posts.add("EEE HEAD");
        posts.add("ME HEAD");
        posts.add("MME HEAD");
        posts.add("PIE HEAD");
        posts.add("CE HEAD");
        posts.add("MCA + MSc HEAD");

        ArrayList<TeamPerson> cse=new ArrayList<TeamPerson>();
        cse.add(new TeamPerson("Sravya",R.drawable.lavu_sravya,"9182884051","https://www.instagram.com/sravyalavu"));
        cse.add(new TeamPerson("Aman Srivastava",R.drawable.avatar,"7903764490","https://www.instagram.com/"));

        ArrayList<TeamPerson> ece=new ArrayList<TeamPerson>();
        ece.add(new TeamPerson("Amit Prakash",R.drawable.amit_prakash,"7992324380","https://www.instagram.com/im_amit_p"));
        ece.add(new TeamPerson("Sweta Kumari",R.drawable.sweta_kumari,"8210938009","https://www.instagram.com/sk_raj52"));

        ArrayList<TeamPerson> eee=new ArrayList<>();
        eee.add(new TeamPerson("Shalini",R.drawable.shalini_sinha,"7870328685","http://instagram.com/_shalinisinha_"));
        eee.add(new TeamPerson("Shivam Singh",R.drawable.shivam_singh,"7229832092","http://instagram.com/i_cvam"));


        ArrayList<TeamPerson> me=new ArrayList<>();
        me.add(new TeamPerson("Amulya Toppo",R.drawable.amulya_toppo,"9771229237","https://www.instagram.com/7_dorcas"));

        ArrayList<TeamPerson> mme=new ArrayList<>();
        mme.add(new TeamPerson("Mansi",R.drawable.mansi_singh,"9973356195","https://www.instagram.com/m.s._.drapetomaniac "));
        mme.add(new TeamPerson("Aditya Kumar",R.drawable.aditya_kumar,"9939721444","https://www.instagram.com/kr_aditya28"));

        ArrayList<TeamPerson> pie=new ArrayList<>();
        pie.add(new TeamPerson("Abhishek Kumar",R.drawable.abhishek_kumar,"7004129994","https://www.instagram.com/kumarabhi72/"));
        pie.add(new TeamPerson("Jyoti Nirala",R.drawable.jyoti_nirala,"7587309970","https://www.instagram.com/nirala_j/"));

        ArrayList<TeamPerson> ce=new ArrayList<>();
        ce.add(new TeamPerson("Simran Kour",R.drawable.simran_kour,"9835330142","https://www.instagram.com/simran_kour735/"));


        ArrayList<TeamPerson> mcamsc=new ArrayList<>();
        mcamsc.add(new TeamPerson("Jitendranath Tudu",R.drawable.jitendranath_tudu,"9046332109","https://www.instagram.com/tudu_j"));

        persons.add(cse);
        persons.add(ece);
        persons.add(eee);
        persons.add(me);
        persons.add(mme);
        persons.add(pie);
        persons.add(ce);
        persons.add(mcamsc);
    }

}
