package org.help;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.help.utilities.AutoComplete;
import org.help.utilities.GPSTracker;
import org.help.utilities.InternetConnection;
import org.help.utilities.PlacesAutoCompleteAdapter;

public class MainActivity extends ActionBarActivity {

    boolean CanAccessLocation = false;
    boolean isInternetConnected = false;
    boolean search = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this,savedInstanceState+"",Toast.LENGTH_LONG).show();
        if(savedInstanceState !=null){
            Boolean outstate = savedInstanceState.getBoolean("bool");
            Toast.makeText(this,outstate+"",Toast.LENGTH_LONG).show();
        }
        setContentView(R.layout.activity_main);

        // Get the latLng of the user...
        GPSTracker gpstracker = new GPSTracker(this);
        LatLng latLng = gpstracker.getLatLng();
        if (latLng != null) {
            CanAccessLocation = true;
        }

        // Check if the user is connected to the Internet..
        InternetConnection connection = new InternetConnection(this);
        if (!connection.isNetConnected()) {
            isInternetConnected = false;
        } else {
            isInternetConnected = true;
        }

        //Set up a custom title bar
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);
        getSupportActionBar().setCustomView(v);

        // Initially the customized autocomplete is hidden.So custom view is disabled.
        getSupportActionBar().setDisplayShowCustomEnabled(false);
        // The title is also disabled.
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        new AutoComplete(this).execute("");

        AutoCompleteTextView mainActivitySearchSuggestions = (AutoCompleteTextView) v
                .findViewById(R.id.main_activity_search);

        mainActivitySearchSuggestions.setAdapter(new PlacesAutoCompleteAdapter(this,
                R.layout.list_item));

        // Initially MapView is displayed.
        setUpView(new MapViewDisplay());

        LinearLayout mainActivityMapViewIcon = (LinearLayout) findViewById(R.id.main_activity_map_view_icon);
        LinearLayout mainActivityListViewIcon = (LinearLayout) findViewById(R.id.main_activity_list_view_icon);

        //When the user clicks on the List button.
        mainActivityListViewIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                setUpView(new ListViewDisplay());
            }
        });

        //When the user clicks on the Map button.
        mainActivityMapViewIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setUpView(new MapViewDisplay());
            }
        });

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

                // openSearch();
                if (search) {
                    getSupportActionBar().setDisplayShowCustomEnabled(true);
                    Drawable actionBarCross = getResources().getDrawable(R.drawable.action_bar_cross);
                    Bitmap bitmap = ((BitmapDrawable) actionBarCross).getBitmap();
                    actionBarCross = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 24, 24, true));
                    item.setIcon(actionBarCross);
                    search = false;
                } else {
                    getSupportActionBar().setDisplayShowCustomEnabled(false);
                    item.setIcon(android.R.drawable.ic_menu_search);
                    search = true;
                }
                return true;
            case R.id.action_filter:
                Intent i2 = new Intent(MainActivity.this, Filter.class);
                startActivity(i2);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
                // openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setUpView(ViewDisplay view) {


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.fragment_container, (Fragment) view);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("bool", true);
    }

}
