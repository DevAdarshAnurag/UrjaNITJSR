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
        devs.add(new Devperson("Aman Srivastava", "7903764490", "https://www.instagram.com/", "https://www.linkedin.com", R.drawable.avatar));
        devs.add(new Devperson("Abhinay Kumar", "#", "https://www.instagram.com/", "https://www.linkedin.com", R.drawable.avatar));
        devs.add(new Devperson("Ritik Raj", "#", "https://www.instagram.com/", "https://www.linkedin.com", R.drawable.avatar));
        recyclerView = findViewById(R.id.recycler);
        developerAdapter = new DeveloperAdapter(devs,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(DevelopersActivity.this));
        recyclerView.setAdapter(developerAdapter);
    }
}
