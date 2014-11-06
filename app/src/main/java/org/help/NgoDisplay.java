package org.help;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class NgoDisplay extends ActionBarActivity {
	
	// ViewPager holds all the pages of NgoDisplay Activity
	 ViewPager mViewPager;
	 
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        setContentView(R.layout.ngodisplay);

	        // ViewPager and its adapters use support library
	        // fragments, so use getSupportFragmentManager.
	        NgoDisplayAdapter mNgoDisplayPagerAdapter =
	                new NgoDisplayAdapter(
	                        getSupportFragmentManager());
	 
	        mViewPager = (ViewPager) findViewById(R.id.pager);
	        mViewPager.setAdapter(mNgoDisplayPagerAdapter);
	        
	        // Create a New ActionBar
	        final ActionBar actionBar = getSupportActionBar();
	       
	       	ViewPager.SimpleOnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
				@Override
				public void onPageSelected(int position) {
					super.onPageSelected(position);
					actionBar.setSelectedNavigationItem(position);
				}

			};

			mViewPager.setOnPageChangeListener(pageChangeListener);

	        // Specify that tabs should be displayed in the action bar.
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	        
	        // Create a tab listener that is called when the user changes tabs.
	        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
	            				
				@Override
				public void onTabReselected(
						android.support.v7.app.ActionBar.Tab arg0,
						FragmentTransaction arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onTabSelected(
						android.support.v7.app.ActionBar.Tab arg0,
						FragmentTransaction arg1) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onTabUnselected(
						android.support.v7.app.ActionBar.Tab arg0,
						FragmentTransaction arg1) {
					// TODO Auto-generated method stub
					
				}
	        };
	        
	        //Add 4 new tabs to the actionBar
	        actionBar.addTab(actionBar.newTab().setText("INFO").setTabListener(tabListener));
	        actionBar.addTab(actionBar.newTab().setText("EVENTS").setTabListener(tabListener));
	        actionBar.addTab(actionBar.newTab().setText("NEEDS").setTabListener(tabListener));
	        actionBar.addTab(actionBar.newTab().setText("ACTIVITY").setTabListener(tabListener));
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//	        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.semicolor));
//	        getSupportActionBar().setStackedBackgroundDrawable(getResources().getDrawable(R.drawable.white));
//	        getSupportActionBar().setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));

     }
	 @Override
		public boolean onCreateOptionsMenu(Menu menu) {
		    // Inflate the menu items for use in the action bar
		    MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.actionbar, menu);
		    return super.onCreateOptionsMenu(menu);
		}
	 
	 @Override
		public boolean onOptionsItemSelected(MenuItem item) {
		    // Handle presses on the action bar items
		    switch (item.getItemId()) {
		        case R.id.action_rate:
		            //openSearch();
		            return true;
		        case R.id.action_review:
		            //openSettings();
		            return true;
		        case R.id.action_follow:
		        	//ngoFollow();
		        	showDialog();
		        	return true;
		        default:
		            return super.onOptionsItemSelected(item);
		    }
		}
	 

	 void showDialog() {
		    DialogFragment newFragment = MyAlertDialogFragment.newInstance(
		            "Follow NGO","After Following the NGO, you will receive all updates via your registered email");
		    newFragment.show(getSupportFragmentManager(), "dialog");
		}

		public void doPositiveClick() {
		    // Do stuff here.
		    Log.i("FragmentAlertDialog", "Positive click!");
		}

		public void doNegativeClick() {
		    // Do stuff here.
		    Log.i("FragmentAlertDialog", "Negative click!");
		}

}
