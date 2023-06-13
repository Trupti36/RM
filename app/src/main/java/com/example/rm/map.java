package com.example.rm;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends AppCompatActivity {
    private LocationManager locationManager;
    SupportMapFragment supportMapFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map1);
        CheckBox myCheckbox = findViewById(R.id.checkBox);
        myCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap map) {

                            LatLng latLng= new LatLng(19.076090,72.877426);
                            MarkerOptions markerOptions = new MarkerOptions();

                            // Setting the position for the marker
                            markerOptions.position(latLng);

                            LatLng latLng2= new LatLng(19.0760999,72.877499);
                            MarkerOptions markerOptions2= new MarkerOptions();

                            // Setting the position for the marker
                            markerOptions2.position(latLng2);


                            // Setting the title for the marker.
                            // This will be displayed on taping the marker
                            markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                            // Clears the previously touched position
                            map.clear();
                            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 40));
                            // Animating to the touched position
                            map.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                            // Placing a marker on the touched position
                            map.addMarker(markerOptions);
                            //  Marker marker =  map.addMarker(new MarkerOptions().position(new LatLng(19.018044, 72.84362)));


                        }
                    });
                } else {
                    // Do something when the CheckBox is unchecked
                }
            }
        });
    }
}