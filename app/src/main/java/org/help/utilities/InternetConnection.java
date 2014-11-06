package org.help.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetConnection {
	
	private Context mContext;
	private ConnectivityManager connectivityManager;
	
	public InternetConnection(Context context) {
		this.mContext=context;
	}

	public boolean isNetConnected() {
		 connectivityManager = (ConnectivityManager) mContext
                 .getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
