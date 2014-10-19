package org.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

public class NgoDisplayFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
   
		int fragmentNumber = getArguments().getInt("fragmentNumber");
		View rootView = inflater.inflate(R.layout.main, container, false);
		if(fragmentNumber==1){
			rootView = inflater.inflate(R.layout.main, container, false);
		}
		if(fragmentNumber==2){
			rootView = inflater.inflate(R.layout.actionbar, container, false);
		}
		return rootView;
}
}
