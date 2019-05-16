package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.MoreItem;
import com.nitjsr.urja1920.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoreListViewAdapter extends BaseAdapter {
    List<MoreItem>moreItems;
    Context context;
    LayoutInflater layoutInflater;

    public MoreListViewAdapter(List<MoreItem> moreItems, Context context) {
        this.moreItems = moreItems;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return moreItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =  layoutInflater.inflate(R.layout.more_list_item, parent, false);
        ImageView imgCountry = convertView.findViewById(R.id.more_image);
        TextView txtName = convertView.findViewById(R.id.more_text);
        MoreItem item = moreItems.get(position);
        txtName.setText(item.name);
        Picasso.get().load(item.imageId).into(imgCountry);
        return convertView;
    }
}
