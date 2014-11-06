package org.help.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class AutoComplete extends AsyncTask<String, Void, List<String>> {

	private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
	private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
	private static final String OUT_JSON = "/json";
	private static final String API_KEY = "AIzaSyBv4MyI6Pz6OOdjqKGgzpaMYvRQEXMnxEI";
	private Context mContext;
	private OnTaskCompleted listener;
	List resultList;
	
	public AutoComplete(Context context) {
		this.mContext=context;
		
	}

	@Override
	protected List<String> doInBackground(String... params) {
		// TODO Auto-generated method stub
		
			String inputPlace = params[0];
	
			HttpURLConnection conn = null;
		    StringBuilder jsonResults = new StringBuilder();
		    try {
		    
		    	StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
		        sb.append("?key=" + API_KEY);
		        sb.append("&components=country:ind");
		        sb.append("&input=" + URLEncoder.encode(inputPlace, "utf8"));
		        
		        URL url = new URL(sb.toString());
		        conn = (HttpURLConnection) url.openConnection();
		        conn.setReadTimeout(10000 /* milliseconds */);
		        conn.setConnectTimeout(15000 /* milliseconds */);
		        conn.setRequestMethod("GET");
		        conn.setDoInput(true);
		        
		        // Starts the query
		        conn.connect();
		        int response = conn.getResponseCode();
		        Log.d("response", "The response is: " + response);
		       
		        InputStreamReader in = new InputStreamReader(conn.getInputStream());

		        // Load the results into a StringBuilder
		        int read;
		        char[] buff = new char[1024];
		        while ((read = in.read(buff)) != -1) {
		            jsonResults.append(buff, 0, read);
		        }
		       
		       Log.d("jsonResults",jsonResults.toString());
		       
		       
		       
		    } catch (MalformedURLException e) {
		        Log.e("MalformedURLException", "Error processing Places API URL", e);
		      
		    } catch (IOException e) {
		        Log.e("IOException", "Error connecting to Places API", e);
		      
		    } finally {
		        if (conn != null) {
		            conn.disconnect();
		        }

	}
		    
		    try {
		        // Create a JSON object hierarchy from the results
		        JSONObject jsonObj = new JSONObject(jsonResults.toString());
		        JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

		        // Extract the Place descriptions from the results
		        resultList = new ArrayList<String>(predsJsonArray.length());
		        for (int i = 0; i < predsJsonArray.length(); i++) {
		        	
		        	Log.d("output",predsJsonArray.getJSONObject(i).getString("description"));
		            resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
		        }
		    } catch (JSONException e) {
		        Log.e("JSONException", "Cannot process JSON results", e);
		    }

			return resultList;

}
	
}
