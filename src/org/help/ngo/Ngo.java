package org.help.ngo;

import java.util.List;

import com.google.android.gms.maps.model.LatLng;

public class Ngo {
	
	public String ngo_id;
	public String ngo_name;
	public String ngo_about;
	public String ngo_address;
	public String ngo_city;
	public LatLng ngo_latlng;
	public String ngo_website;
	public Double ngo_reviews;
	
	public List<Event> ngo_events;
	public List<Wish> ngo_wishes;
	public List<Category> ngo_categories;
	public List<String> ngo_contacts;
	public List<String> ngo_images;

}
