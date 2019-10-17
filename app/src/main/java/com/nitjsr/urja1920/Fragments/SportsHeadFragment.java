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
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons,getContext());
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

        ArrayList<TeamPerson> VolleyHead=new ArrayList<TeamPerson>();
        VolleyHead.add(new TeamPerson("Mritunjay Kumar",R.drawable.mritunjay_kumar,"######","http://instagram.com/"));
        VolleyHead.add(new TeamPerson("Poonam Kujur",R.drawable.poonam,"####","http://instagram.com/"));

        ArrayList<TeamPerson> BasketHead=new ArrayList<TeamPerson>();
        BasketHead.add(new TeamPerson("Abhishek Mishra",R.drawable.abhishekh_kumar_mishra,"#######","http://instagram.com/"));
        BasketHead.add(new TeamPerson("Shivani Thakur",R.drawable.shivani_thakur,"7073966727","https://www.instagram.com/_vivacious_28"));

        ArrayList<TeamPerson> HockeyHead=new ArrayList<TeamPerson>();
        HockeyHead.add(new TeamPerson("Akash Kumar Rajwar",R.drawable.akash_rajwar,"7004316234","https://www.instagram.com/badass_rajwar_7"));


        ArrayList<TeamPerson> AthletHead=new ArrayList<TeamPerson>();
        AthletHead.add(new TeamPerson("Surendra Junawa",R.drawable.surendra_junawa,"#######","http://instagram.com/"));
        AthletHead.add(new TeamPerson("Riya Mehta",R.drawable.riya_mehta,"7870349214","http://instagram.com/"));

        ArrayList<TeamPerson> BadHead=new ArrayList<TeamPerson>();
        BadHead.add(new TeamPerson("Basant Jha",R.drawable.basant,"8340355127","http://instagram.com/basantjha70"));
        BadHead.add(new TeamPerson("Smita Kumari",R.drawable.smita_kumari,"####","http://instagram.com/"));

        ArrayList<TeamPerson> TableHead=new ArrayList<TeamPerson>();
        TableHead.add(new TeamPerson("Yatharth Rohtagi",R.drawable.yatharth_rohatgi,"######","http://instagram.com/"));
        TableHead.add(new TeamPerson("Shrutika",R.drawable.shrutika_shukla,"7632007676","http://instagram.com/shrutikashukla7"));

        ArrayList<TeamPerson> CricketHead=new ArrayList<TeamPerson>();
        CricketHead.add(new TeamPerson("Surendra Oraon",R.drawable.sulendra_oroan,"######","http://instagram.com/"));


        ArrayList<TeamPerson> ChessHead=new ArrayList<TeamPerson>();
        ChessHead.add(new TeamPerson("Isharul Haque",R.drawable.isharul_haque,"8210274067","http://instagram.com/isharulhaque"));
        ChessHead.add(new TeamPerson("Usha",R.drawable.usha_kumari,"#######","http://instagram.com/"));



        ArrayList<TeamPerson> FootballHead=new ArrayList<TeamPerson>();
        FootballHead.add(new TeamPerson("Gurdeep Singh Dagar",R.drawable.gurdeep_dagar,"8979660904","http://instagram.com/gurdeep_dagar001"));



        persons.add(VolleyHead);
        persons.add(BasketHead);
        persons.add(HockeyHead);
        persons.add(AthletHead);
        persons.add(BadHead);
        persons.add(TableHead);
        persons.add(CricketHead);
        persons.add(ChessHead);
        persons.add(FootballHead);

         }

}
