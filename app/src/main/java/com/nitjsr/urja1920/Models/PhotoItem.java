package com.nitjsr.urja1920.Models;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nitjsr.urja1920.R;

import fr.rolandl.carousel.CarouselItem;

public final class PhotoItem
        extends CarouselItem<Photo>
{

    private ImageView image;

    private TextView name;

    private Context context;

    public PhotoItem(Context context)
    {
        super(context, R.layout.carousel_item_layout);
        this.context = context;
    }

    @Override
    public void extractView(View view)
    {
        image = (ImageView) view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.name);
    }

    @Override
    public void update(Photo photo)
    {
        image.setImageResource(photo.image);
        name.setText(photo.name);
    }

}
