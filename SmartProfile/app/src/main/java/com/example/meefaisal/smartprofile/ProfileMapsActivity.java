package com.example.meefaisal.smartprofile;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        Toast.makeText(this, getIntent().getStringExtra("lat"), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, getIntent().getStringExtra("lon"), Toast.LENGTH_SHORT).show();

        double lat = Double.parseDouble(getIntent().getStringExtra("lat"));
        double lon = Double.parseDouble(getIntent().getStringExtra("lon"));

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(latLng).title("You are here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(lat,  lon))
                .radius(100)
                .strokeColor(Color.RED));
    }
}
