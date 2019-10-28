package com.nitjsr.urja1920.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.Events;
import com.nitjsr.urja1920.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<Events> list;
    private int lastPosition =-1;
    private onItemClicked onClick;

    public EventAdapter(Context context, List<Events> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.event_item_layout, parent, false);
        return (new EventViewHolder(itemView));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Events curr = list.get(position);
        //holder.event_name.setText(curr.getEventName());
        holder.event_image.setImageResource(curr.getEventThumbnail());
        setAnimation(holder.itemView, position);
        holder.event_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.onItemClick(position);
            }
        });
    }

    private void setAnimation(View view, int position) {
        if (lastPosition < position) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_from_bottom);
            view.startAnimation(animation);
        } else {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_from_top);
            view.startAnimation(animation);
        }
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClick(onItemClicked onClick) {
        this.onClick = onClick;
    }

    public interface onItemClicked {
        void onItemClick(int position);
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        public ImageView event_image;

        public EventViewHolder(View itemView) {
            super(itemView);
            event_image = itemView.findViewById(R.id.event_image);
        }
    }
}
