package com.nitjsr.urja1920.Activities;

import android.os.Bundle;

import com.nitjsr.urja1920.Adapters.DeveloperAdapter;
import com.nitjsr.urja1920.Models.Devperson;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DevelopersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DeveloperAdapter developerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        ArrayList<Devperson> devs = new ArrayList<>();
        devs.add(new Devperson("Adarsh Anurag", "9801540653", "https://www.instagram.com/adarsh_nightmare_anurag", "https://www.linkedin.com/in/adarsh-anurag-b7a0ba128/", R.drawable.adarsh_anurag));
        devs.add(new Devperson("Aman Srivastava", "7903764490", "https://www.instagram.com/", "https://www.linkedin.com/in/aman-kumar-srivastava-27152113a", R.drawable.aman_srivastava));
        devs.add(new Devperson("Abhinay Kumar", "88253 26346", "https://www.instagram.com/kumarabhinay599", "https://www.linkedin.com/in/abhinay-kumar-3b3345178", R.drawable.abhinay));
        devs.add(new Devperson("Ritik Raj", "8709184657", "https://www.instagram.com/rajlevel", "https://www.linkedin.com/in/ritik-raj-67870817a", R.drawable.ritik_raj));
        recyclerView = findViewById(R.id.recycler);
        developerAdapter = new DeveloperAdapter(devs,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(DevelopersActivity.this));
        recyclerView.setAdapter(developerAdapter);
    }
}
