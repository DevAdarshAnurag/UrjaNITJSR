package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.Fixture;
import com.nitjsr.urja1920.R;

import java.util.List;

public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    Context context;
    List<Fixture> fixtureList;
    private onItemClicked onClick;

    public UpcomingAdapter(Context context, List<Fixture> fixtureList) {
        this.context = context;
        this.fixtureList = fixtureList;
    }

    @NonNull
    @Override
    public UpcomingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.match_list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Fixture fixture = fixtureList.get(i);
        viewHolder.matchName.setText(fixture.getmatchName(fixture.getType()-1));
        if(fixture.getType()==9) {
            viewHolder.teamNames.setText(fixture.getTeam1().toUpperCase());
        }
        else {
            viewHolder.teamNames.setText(fixture.getTeam1().toUpperCase() + " vs " + fixture.getTeam2().toUpperCase());
        }
        viewHolder.result.setText(fixture.getDate());
        viewHolder.roundName.setText(fixture.getRoundName());
        viewHolder.matchScores.setVisibility(View.INVISIBLE);
        viewHolder.matchset1.setVisibility(View.GONE);
        viewHolder.matchset2.setVisibility(View.GONE);
        viewHolder.matchset3.setVisibility(View.GONE);
        viewHolder.matchset4.setVisibility(View.GONE);
        viewHolder.matchset5.setVisibility(View.GONE);
        viewHolder.matchName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(i);
            }
        });
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

    public void setOnClick(onItemClicked onClick) {
        this.onClick = onClick;
    }

    public interface onItemClicked {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView matchName;
        public TextView teamNames;
        public TextView result;
        public TextView roundName;
        public LinearLayout matchScores, matchset1,matchset2,matchset3,matchset4,matchset5;
        public TextView s11,s12,s21,s22,s31,s32,s41,s42,s51,s52;

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
