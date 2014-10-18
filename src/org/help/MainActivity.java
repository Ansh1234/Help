package org.help;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.help.utilities.*;

public class MainActivity extends ActionBarActivity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		// Get the location of the user...
		GPSTracker gpstracker = new GPSTracker(this);
		Location location  = gpstracker.getLocation();
		if(location != null) {
			Toast.makeText(getApplicationContext(),Double.toString(location.getLatitude()), Toast.LENGTH_LONG).show();
		}
		
		// Check if the user is connected to the Internet..
		InternetConnection connection = new InternetConnection(this);
		if(!connection.isNetConnected()) {
			Toast.makeText(getApplicationContext(), "Please check your internet connection..", Toast.LENGTH_LONG).show();
		}
		else {
			Toast.makeText(getApplicationContext(), "Congrats...You are connected to Internet", Toast.LENGTH_LONG).show();
		}
		
		 new AutoComplete(this).execute("Ban");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            //openSearch();
	            return true;
	        case R.id.action_settings:
	            //openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
