package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.Leaderboard;
import com.nitjsr.urja1920.R;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.MyViewHolder> {
    private List<Leaderboard> list;
    private Context context;

    public LeaderboardAdapter(List<Leaderboard> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Leaderboard l = list.get(position);
        holder.branch.setText(l.branch);
        holder.count_gold.setText(l.gold);
        holder.count_silver.setText(l.silver);
        holder.count_bronze.setText(l.bronze);
        holder.count_total.setText(l.total);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView rank, branch, count_gold, count_silver, count_bronze, count_total;

        public MyViewHolder(View view) {
            super(view);
            branch = view.findViewById(R.id.branch_name);
            count_gold = view.findViewById(R.id.gold);
            count_silver = view.findViewById(R.id.silver);
            count_bronze = view.findViewById(R.id.bronze);
            count_total = view.findViewById(R.id.points);
        }
    }
}

