package com.nitjsr.urja1920.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nitjsr.urja1920.Adapters.CoreTeamAdapter;
import com.nitjsr.urja1920.R;
import android.os.Bundle;

import com.nitjsr.urja1920.Models.TeamPerson;

import java.util.ArrayList;

public class CoreTeamActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> posts;
    ArrayList<ArrayList<TeamPerson>> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreteam);

        posts=new ArrayList<String>();
        persons=new ArrayList<ArrayList<TeamPerson>>();
        fillData();
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CoreTeamAdapter coreTeamAdapter=new CoreTeamAdapter(posts,persons);
        recyclerView.setAdapter(coreTeamAdapter);
    }

    public  void fillData()
    {
        posts.add("Head");
        posts.add("Head");
        posts.add("Head");

        ArrayList<TeamPerson> name=new ArrayList<TeamPerson>();
        name.add(new TeamPerson("Raja Kumar Singh Sinha Rajput",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));

        ArrayList<TeamPerson> name1=new ArrayList<TeamPerson>();
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
        name1.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));

        ArrayList<TeamPerson> name3=new ArrayList<>();
        name3.add(new TeamPerson("Abhinay",R.drawable.avatar,"8825326346","http://instagram.com/"));
         persons.add(name3);
         persons.add(name1);
         persons.add(name);



    }
}
