package org.help;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.w3c.dom.Document;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class NgoInfoDirections extends FragmentActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ngo_info_directions);
		LatLng fromPosition = new LatLng(12.959593,  77.658057);
		LatLng toPosition = new LatLng(12.957029, 77.705338);

		GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.ngo_info_directions_map)).getMap();
		GMapV2Direction md = new GMapV2Direction();
		
	
		getDocument task = new getDocument();
		task.execute(fromPosition,toPosition);
		Document doc = null;
		try {
			doc = task.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Document doc = md.getDocument(fromPosition, toPosition,
			//	GMapV2Direction.MODE_DRIVING);
		if (doc == null) {
			Log.d("Nu", "nU");
		} else {
			Log.d("yes","yes");
			ArrayList<LatLng> directionPoint = md.getDirection(doc);
			Log.d("number",directionPoint.size()+"");
			PolylineOptions rectLine = new PolylineOptions().width(10).color(
					Color.CYAN);

			for (int i = 0; i < directionPoint.size(); i++) {
				rectLine.add(directionPoint.get(i));
			}

		    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fromPosition, 14.5f));
			mMap.addPolyline(rectLine);
			mMap.addMarker(new MarkerOptions()
              .position(fromPosition)
              .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
			mMap.addMarker(new MarkerOptions()
            .position(toPosition)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
			
		}
	}

}
