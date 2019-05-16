package com.nitjsr.urja1920.Adapters;

import android.content.Context;

import java.util.List;

import com.nitjsr.urja1920.Models.Photo;
import com.nitjsr.urja1920.Models.PhotoItem;

import fr.rolandl.carousel.CarouselAdapter;
import fr.rolandl.carousel.CarouselItem;

public final class MyCarouselAdapter extends CarouselAdapter<Photo>
{

    public MyCarouselAdapter(Context context, List<Photo> photos)
    {
        super(context, photos);
    }

    @Override
    public CarouselItem<Photo> getCarouselItem(Context context) {
        return new PhotoItem(context);
    }


}