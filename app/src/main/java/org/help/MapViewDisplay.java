package org.help;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import org.help.utilities.DraggableCircle;
import org.help.utilities.GPSTracker;
import org.help.utilities.MapDisplay;

public class MapViewDisplay extends Fragment implements ViewDisplay {

    private GoogleMap googleMap;
    private MapView mMapView;
    private int mFillColor = Color.TRANSPARENT;
    float[] f  = {};
    //private int mStrokeColor = Color.HSVToColor(f);
    private int mStrokeColor  = Color.rgb(102,153,0);
    private double radius =25000.00;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.mapviewdisplay, container,
                false);
        mMapView = (MapView) v.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        googleMap = mMapView.getMap();


        LatLng latlng = new GPSTracker(getActivity()).getLatLng();

        //this function is used to focus on the given LatLng
        MapDisplay.setCameraPosition(googleMap,latlng);
        DraggableCircle circle = new DraggableCircle(latlng,googleMap,mFillColor,mStrokeColor,radius);
        LatLng one = new LatLng(12.937305, 77.626600);
        LatLng two = new LatLng(12.959676, 77.657982);
        LatLng three = new LatLng(12.932081, 77.556859);
        LatLng four = new LatLng(12.977206, 77.572777);


        MapDisplay.addMarkersToMap(one,googleMap);
        MapDisplay.addMarkersToMap(two,googleMap);
        MapDisplay.addMarkersToMap(three,googleMap);
        MapDisplay.addMarkersToMap(four,googleMap);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }}