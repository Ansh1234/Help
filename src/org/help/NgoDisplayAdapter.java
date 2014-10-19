package org.help;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

public class NgoDisplayAdapter extends FragmentPagerAdapter {
	  
		public NgoDisplayAdapter(android.support.v4.app.FragmentManager fm) {
	        super(fm);
	    }
		
		@Override
	    public android.support.v4.app.Fragment getItem(int i) {
	        NgoDisplayFragment fragment = new NgoDisplayFragment();
	        Bundle args = new Bundle();
	        args.putInt("fragmentNumber", i + 1);
	        fragment.setArguments(args);
	        return fragment;
	    }

	    @Override
	    public int getCount() {
	        return 4;
	    }

	    @Override
	    public CharSequence getPageTitle(int position) {
	  	return null;
	    }

}
