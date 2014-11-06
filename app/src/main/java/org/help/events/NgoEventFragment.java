package org.help.events;

import org.help.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class NgoEventFragment extends Fragment implements
		OnSeekBarChangeListener, OnInfoWindowClickListener,
		OnMarkerDragListener, OnMapLongClickListener {

	private GoogleMap googleMap;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.ngo_events, container, false);
		MapView mMapView = (MapView) rootView
				.findViewById(R.id.ngo_events_directionsMap);
		mMapView.onCreate(savedInstanceState);
		mMapView.onResume();
		googleMap = mMapView.getMap();
		googleMap.setOnMarkerDragListener(this);
		googleMap.setOnMapLongClickListener(this);

		try {
			MapsInitializer.initialize(getActivity().getApplicationContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Double latitude = new Double(12.959634);
		Double longitude = new Double(77.658036);
		LatLng latlng = new LatLng(latitude, longitude);
		googleMap.addMarker(new MarkerOptions().position(latlng).icon(
				BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

		googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f));
		googleMap.setOnInfoWindowClickListener(this);
		return rootView;
	}

	@Override
	public void onMapLongClick(LatLng point) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMarkerDrag(Marker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMarkerDragEnd(Marker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMarkerDragStart(Marker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}
}
