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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nitjsr.urja1920.Models.TeamPerson;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CoreTeamAdapter extends RecyclerView.Adapter<CoreTeamAdapter.MyViewHolder> {

    ArrayList<String> posts;
    ArrayList<ArrayList<TeamPerson>> persons;
    Context context;


    public  CoreTeamAdapter(ArrayList<String>posts, ArrayList<ArrayList<TeamPerson>> persons, Context context)
    {
        this.posts=posts;
        this.persons=persons;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        holder.last_person_name.setText(persons.get(position).get(persons.get(position).size()-1).getName());
        holder.last_person_image.setImageResource(persons.get(position).get(persons.get(position).size()-1).getImgurl());
        holder.last_person_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+persons.get(position).get(persons.get(position).size()-1).getPhone()));
                context.startActivity(intent);
            }
        });
        holder.last_person_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(persons.get(position).get(persons.get(position).size()-1).getInsta()));
                context.startActivity(intent);
            }
        });
        if(persons.get(position).size()%2==0)
            holder.card.setVisibility(View.GONE);
        else
            holder.card.setVisibility(View.VISIBLE);
        ArrayList<TeamPerson> dupli=new ArrayList<>(persons.get(position));
        if(dupli.size()%2!=0)
            dupli.remove(dupli.size()-1);
        InnerCoreTeamAdapter innerCoreTeamAdapter=new InnerCoreTeamAdapter(dupli);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);

        holder.post.setText(posts.get(position));
        holder.innerrecyclerview.setAdapter(innerCoreTeamAdapter);
        holder.innerrecyclerview.setLayoutManager(gridLayoutManager);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        RecyclerView innerrecyclerview;
        TextView post;
        TextView last_person_name;
        CircleImageView last_person_image;
        ImageView last_person_phone,last_person_insta;
        CardView card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            innerrecyclerview=itemView.findViewById(R.id.inner_recycler_view);
            post=itemView.findViewById(R.id.post);
            last_person_name=itemView.findViewById(R.id.person_name);
            card=itemView.findViewById(R.id.card);
            last_person_image=itemView.findViewById(R.id.person_image);
            last_person_phone=itemView.findViewById(R.id.person_phone);
            last_person_insta=itemView.findViewById(R.id.person_insta);
        }
    }
}
