package org.help;



import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class NgoDisplay extends ActionBarActivity {
	
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
	        
	        //Whenever the user selects a new tab, the new tab is highlighted with it
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
	        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.semicolor));
	 }

}
