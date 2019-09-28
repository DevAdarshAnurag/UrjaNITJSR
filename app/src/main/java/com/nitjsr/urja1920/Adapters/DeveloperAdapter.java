package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nitjsr.urja1920.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nitjsr.urja1920.Models.Devperson;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.MyViewHolder> {
    ArrayList<Devperson> devs;
    int pos;
    Context context;
    public  DeveloperAdapter(ArrayList<Devperson> devs)
    {
        this.devs=devs;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list_item,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        pos=position;
        holder.devname.setText(devs.get(position).getName());
        holder.devimg.setImageResource(devs.get(position).getImg());
        holder.insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(devs.get(pos).getInsta()));
            }
        });

        holder.linkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(devs.get(pos).getLinkd()));

            }
        });

        holder.whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(devs.get(pos).getWhats()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return devs.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView devimg;
        TextView devname;
        ImageView insta,linkd,whats;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            devimg=itemView.findViewById(R.id.dev_image);
            devname=itemView.findViewById(R.id.dev_name);
            insta=itemView.findViewById(R.id.insta);
            whats=itemView.findViewById(R.id.whats);
            linkd=itemView.findViewById(R.id.linkd);
        }
    }
}
