package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.Devperson;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.MyViewHolder> {
    ArrayList<Devperson> devs;
    Context context;

    public DeveloperAdapter(ArrayList<Devperson> devs, Context context) {
        this.devs = devs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.devname.setText(devs.get(position).getName());
        holder.devimg.setImageResource(devs.get(position).getImg());
        holder.insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(devs.get(position).getInsta()));
                context.startActivity(intent);
            }
        });

        holder.linkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(devs.get(position).getLinkd()));
                context.startActivity(intent);
            }
        });

        holder.whats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + devs.get(position).getWhats()));
                context.startActivity(intent);
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
        ImageView insta, linkd, whats;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            devimg = itemView.findViewById(R.id.dev_image);
            devname = itemView.findViewById(R.id.dev_name);
            insta = itemView.findViewById(R.id.insta);
            whats = itemView.findViewById(R.id.whats);
            linkd = itemView.findViewById(R.id.linkd);
        }
    }
}
