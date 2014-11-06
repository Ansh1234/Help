package org.help.utilities;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by anshul on 31/10/14.
 */
public class MapDisplay {

    public static void addMarkersToMap(LatLng latlng,GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(latlng)
                .title("")
                .snippet("")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }

    public static void setCameraPosition(GoogleMap googleMap,LatLng latlng){

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latlng).zoom(10).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
    }





}
