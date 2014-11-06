package org.help;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class getDocument extends AsyncTask<LatLng, Object, Document> {

	@Override
	protected Document doInBackground(LatLng... params) {
		LatLng start = params[0];
		LatLng end = params[1];
		
		// TODO Auto-generated method stub
		  String url = "http://maps.googleapis.com/maps/api/directions/xml?" 
	                + "origin=" + start.latitude + "," + start.longitude  
	                + "&destination=" + end.latitude + "," + end.longitude 
	                + "&sensor=false&units=metric&mode=driving";
	        Log.d("url",url);

	        try {
	            HttpClient httpClient = new DefaultHttpClient();
	            HttpPost httpPost = new HttpPost(url);
	            HttpResponse response = httpClient.execute(httpPost);
	            InputStream in = response.getEntity().getContent();
	            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document doc = builder.parse(in);
	           
	            if(doc==null){
	            	Log.d("ansh","ansh");
	            }
	            else {
	            	Log.d("aman","aman");
	            	
	            	 Log.d("docu",doc.toString());
	            }
	            return doc;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      
		return null;
	}

}
