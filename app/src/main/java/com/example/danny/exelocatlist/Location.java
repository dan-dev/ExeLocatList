package com.example.danny.exelocatlist;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Location {

    String Name;
    String Image;
    LatLng Coord;
    //BitmapDescriptorFactory image;

    public Location() {
        super();
    }

    public Location(String name, String image, LatLng coord) {
        Name = name;
        Image = image;
        Coord = coord;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public LatLng getCoord() {
        return Coord;
    }

    public void setCoord(LatLng coord) {
        Coord = coord;
    }

    public List<Location> getLoactionList(){
        List<Location> list = new ArrayList<>();

        list.add(new Location("Porto", "porto", new LatLng(41.149803, -8.610703)));
        list.add(new Location("Maia", "maia", new LatLng(41.232931, -8.622427)));
        list.add(new Location("Lisboa", "lisboa", new LatLng(38.749579, -9.150046)));
        list.add(new Location("Trofa", "trofa", new LatLng(41.330668, -8.566435)));
        list.add(new Location("Sendai", "sendai", new LatLng(38.260358, 140.882334)));
        list.add(new Location("Kennedy Space Center", "spacecenter", new LatLng(28.523087, -80.681621)));

        return list;
    }

}