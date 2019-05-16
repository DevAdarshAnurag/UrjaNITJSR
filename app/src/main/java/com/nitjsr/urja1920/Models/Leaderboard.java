package com.nitjsr.urja1920.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Leaderboard {
    public String gold;
    public String silver;
    public String bronze;
    public String total;
    public String branch;
    public Leaderboard(){

    }

    public Leaderboard(String branch,String gold,String silver,String bronze,String total)
    {
        this.branch = branch;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.total = total;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("branch",branch);
        result.put("gold",gold );
        result.put("silver",silver);
        result.put("bronze",bronze);
        result.put("total",total);

        return result;
    }

}