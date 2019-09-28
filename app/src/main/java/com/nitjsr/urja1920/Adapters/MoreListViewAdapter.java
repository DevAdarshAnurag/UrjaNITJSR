package com.nitjsr.urja1920.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.nitjsr.urja1920.Models.MoreItem;
import com.nitjsr.urja1920.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MoreListViewAdapter extends ArrayAdapter<MoreItem> {

    public MoreListViewAdapter(List<MoreItem> moreItems, Context context) {
        super(context, 0, moreItems);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MoreItem item = getItem(position);
        View view = convertView;
        if (convertView == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.more_list_item, parent, false);
        CircleImageView imgCountry = view.findViewById(R.id.more_image);
        imgCountry.setImageResource(item.getImageId());
        TextView txtName = view.findViewById(R.id.more_text);
        txtName.setText(item.getName());
        return view;
    }

}
