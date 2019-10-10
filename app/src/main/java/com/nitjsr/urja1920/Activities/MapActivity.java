package com.nitjsr.urja1920.Activities;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nitjsr.urja1920.R;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        overridePendingTransition(0, 0);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.maps_style));

            if (!success) {
                Log.e("Gmap", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("Gmap", "Can't find style. Error: ", e);
        }


        LatLng loc = new LatLng(22.775032, 86.143945);
        LatLng hockeyGround = new LatLng(22.772673, 86.143152);
        LatLng tsg = new LatLng(22.775032, 86.143945);
        LatLng upsGround = new LatLng(22.780951, 86.143343);
//        LatLng hockeyGround = new LatLng();
//        LatLng hockeyGround = new LatLng();
//        LatLng hockeyGround = new LatLng();
//        LatLng hockeyGround = new LatLng();

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(loc)      // Sets the center of the map to Mountain View
                .zoom(17)                   // Sets the zoom
                .bearing(0)
                .tilt(90)
                .build();
        int height = 100;
        int width = 100;
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.lion);
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        BitmapDescriptor smallMarkerIcon = BitmapDescriptorFactory.fromBitmap(smallMarker);
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.addMarker(new MarkerOptions().position(hockeyGround).title("Hockey Ground").icon(smallMarkerIcon));
        googleMap.addMarker(new MarkerOptions().position(tsg).title("TSG").icon(smallMarkerIcon));
        googleMap.addMarker(new MarkerOptions().position(upsGround).title("Football Ground").icon(smallMarkerIcon));

        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setAllGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
    }

}
