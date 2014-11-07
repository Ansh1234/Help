package org.help.adapters;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;

import org.help.NgoDonationFragment;
import org.help.NgoInformationFragment;
import org.help.events.NgoEventFragment;

public class NgoDisplayAdapter extends FragmentPagerAdapter {
	  
		public NgoDisplayAdapter(android.support.v4.app.FragmentManager fm) {
	        super(fm);
	    }
		
		@Override
	    public android.support.v4.app.Fragment getItem(int i) {
			
			if(i==0){
			        NgoInformationFragment fragment = new NgoInformationFragment();
			        Bundle args = new Bundle();
			        return fragment;
			}
			else if(i==1){
					NgoEventFragment fragment = new NgoEventFragment();
					return fragment;
			}
			else if(i==2){
				    NgoInformationFragment fragment = new NgoInformationFragment();
				    return fragment;
			}
            else {
                NgoDonationFragment fragment = new NgoDonationFragment();
                return fragment;
            }
	       
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
