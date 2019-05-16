package com.nitjsr.urja1920.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nitjsr.urja1920.Adapters.MyCarouselAdapter;
import com.nitjsr.urja1920.Models.Photo;
import com.nitjsr.urja1920.R;

import java.util.ArrayList;
import java.util.List;

import fr.rolandl.carousel.Carousel;
import fr.rolandl.carousel.CarouselAdapter;
import fr.rolandl.carousel.CarouselBaseAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onActivityCreated(savedInstanceState);
        final Carousel carousel = (Carousel) view.findViewById(R.id.carousel);

        final List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("Developers", R.mipmap.ic_launcher));
        photos.add(new Photo("Team Urja", R.mipmap.ic_launcher));
        photos.add(new Photo("About Us", R.mipmap.ic_launcher_round));

        final CarouselAdapter adapter = new MyCarouselAdapter(getContext(), photos);
        carousel.setAdapter(adapter);
        carousel.setSelection(2, true);
        adapter.notifyDataSetChanged();
        carousel.setOnItemClickListener(new CarouselBaseAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(CarouselBaseAdapter<?> carouselBaseAdapter, View view, int position, long id) {
                //Toast.makeText(getContext(), "The item '" + position + "' has been clicked", Toast.LENGTH_SHORT).show();
                carousel.scrollToChild(position);
            }

        });

    }

}
