package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.TeamPerson;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class InnerCoreTeamAdapter extends RecyclerView.Adapter<InnerCoreTeamAdapter.MyInnerViewHolder> {

    ArrayList<TeamPerson> persons;
    Context context;

    public InnerCoreTeamAdapter(ArrayList<TeamPerson> persons) {
        this.persons = persons;
    }


    @NonNull
    @Override
    public MyInnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.persons, parent, false);
        MyInnerViewHolder myInnerViewHolder = new MyInnerViewHolder(view);
        return myInnerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyInnerViewHolder holder, final int position) {
        holder.person_name.setText(persons.get(position).getName());
        holder.person_image.setImageResource(persons.get(position).getImgurl());
        holder.person_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + persons.get(position).getPhone()));
                context.startActivity(intent);
            }
        });

        holder.person_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(persons.get(position).getInsta()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    class MyInnerViewHolder extends RecyclerView.ViewHolder {

        TextView person_name;
        CircleImageView person_image;
        ImageView person_insta, person_phone;

        public MyInnerViewHolder(@NonNull View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.person_name);
            person_image = itemView.findViewById(R.id.person_image);
            person_insta = itemView.findViewById(R.id.person_insta);
            person_phone = itemView.findViewById(R.id.person_phone);
        }
    }
}
