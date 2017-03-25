package com.example.danny.exelocatlist;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int id;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        List<LatLng> coordsList = new ArrayList<>();

        final Location location = new Location();
        final List<Location> listMarks = location.getLoactionList();

        for (Location l : listMarks){
            LatLng latLng = l.getCoord();
            mMap.addMarker(new MarkerOptions().position(latLng).title(l.getName())).setTag(l.getName());
            coordsList.add(latLng);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordsList.get(id), 10f));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener(){
            @Override
            public boolean onMarkerClick(Marker marker) {
                googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){
                    @Override
                    public View getInfoWindow(Marker marker) {
                        View v = getLayoutInflater().inflate(R.layout.layout_info_window, null);

                        TextView textView = (TextView) v.findViewById(R.id.text);
                        TextView textView2 = (TextView) v.findViewById(R.id.text2);
                        ImageView imageView = (ImageView) v.findViewById(R.id.image);

                        for(Location l : listMarks){
                            if (l.getName().equals(marker.getTag())){
                                textView.setText(l.getName());
                                textView2.setText(l.getCoord().toString());
                                Resources resources = context.getResources();
                                final int res = resources.getIdentifier(l.getImage(), "drawable", context.getPackageName());
                                imageView.setImageResource(res);
                            }
                        }
                        return v;
                    }
                    @Override
                    public View getInfoContents(Marker marker) { return null; }
                });
                return false;
            }
        });
    }
}