package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.Fixture;
import com.nitjsr.urja1920.R;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    Context context;
    List<Fixture> fixtureList;

    public MatchesAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    @NonNull
    @Override
    public MatchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.match_list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fixture fixture = fixtureList.get(i);
        viewHolder.matchName.setText(fixture.getmatchName(fixture.getType()-1));
        if(fixture.getType()==9)
        {
            viewHolder.teamNames.setText(fixture.getTeam1().toUpperCase());
        }
        else {
            viewHolder.teamNames.setText(fixture.getTeam1().toUpperCase() + " vs " + fixture.getTeam2().toUpperCase());
        }
        viewHolder.result.setText("Live");
        viewHolder.roundName.setText(fixture.getRoundName());
        if(fixture.getScore1().equals("") && fixture.getScore2().equals(""))
        {
            viewHolder.matchScores.setVisibility(View.INVISIBLE);
        }
        else
        {
            viewHolder.matchScores.setVisibility(View.VISIBLE);
            viewHolder.score1.setText(fixture.getScore1());
            viewHolder.score2.setText(fixture.getScore2());
        }
        if(fixture.getS11().equals("") && fixture.getS12().equals(""))
        {
            viewHolder.matchset1.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.matchset1.setVisibility(View.VISIBLE);
            viewHolder.s11.setText(fixture.getS11());
            viewHolder.s12.setText(fixture.getS12());
        }
        if(fixture.getS21().equals("") && fixture.getS22().equals(""))
        {
            viewHolder.matchset2.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.matchset2.setVisibility(View.VISIBLE);
            viewHolder.s21.setText(fixture.getS21());
            viewHolder.s22.setText(fixture.getS22());
        }
        if(fixture.getS31().equals("") && fixture.getS32().equals(""))
        {
            viewHolder.matchset3.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.matchset3.setVisibility(View.VISIBLE);
            viewHolder.s31.setText(fixture.getS31());
            viewHolder.s32.setText(fixture.getS32());
        }
        if(fixture.getS41().equals("") && fixture.getS42().equals(""))
        {
            viewHolder.matchset4.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.matchset4.setVisibility(View.VISIBLE);
            viewHolder.s41.setText(fixture.getS41());
            viewHolder.s42.setText(fixture.getS42());
        }
        if(fixture.getS51().equals("") && fixture.getS52().equals(""))
        {
            viewHolder.matchset5.setVisibility(View.GONE);
        }
        else
        {
            viewHolder.matchset5.setVisibility(View.VISIBLE);
            viewHolder.s51.setText(fixture.getS51());
            viewHolder.s52.setText(fixture.getS52());
        }
    }

    @Override
    public int getItemViewType(int position) {
        Fixture fixture = fixtureList.get(position);
        return fixture.getType();
    }

    @Override
    public int getItemCount() {
        return fixtureList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView matchName;
        public TextView teamNames;
        public TextView result;
        public TextView roundName;
        public LinearLayout matchScores, matchset1,matchset2,matchset3,matchset4,matchset5;
        public TextView s11,s12,s21,s22,s31,s32,s41,s42,s51,s52,score1,score2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            matchName = itemView.findViewById(R.id.match_name);
            teamNames = itemView.findViewById(R.id.match_teams);
            result = itemView.findViewById(R.id.match_result);
            roundName = itemView.findViewById(R.id.match_round);
            matchScores = itemView.findViewById(R.id.match_score);
            matchset1 = itemView.findViewById(R.id.match_sets1);
            matchset2 = itemView.findViewById(R.id.match_sets2);
            matchset3 = itemView.findViewById(R.id.match_sets3);
            matchset4 = itemView.findViewById(R.id.match_sets4);
            matchset5 = itemView.findViewById(R.id.match_sets5);
            score1 = itemView.findViewById(R.id.match_score_1);
            score2 = itemView.findViewById(R.id.match_score_2);
            s11 = itemView.findViewById(R.id.match_sets_11);
            s12 = itemView.findViewById(R.id.match_sets_12);
            s21 = itemView.findViewById(R.id.match_sets_21);
            s22 = itemView.findViewById(R.id.match_sets_22);
            s31 = itemView.findViewById(R.id.match_sets_31);
            s32 = itemView.findViewById(R.id.match_sets_32);
            s41 = itemView.findViewById(R.id.match_sets_41);
            s42 = itemView.findViewById(R.id.match_sets_42);
            s51 = itemView.findViewById(R.id.match_sets_51);
            s52 = itemView.findViewById(R.id.match_sets_52);
        }
    }
}
