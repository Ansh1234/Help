package org.help;

import java.util.ArrayList;

public class NgoInfoImages {
	  private ArrayList<Integer> imageId;
	  
	    public NgoInfoImages() {
	        imageId = new ArrayList<Integer>();
	        imageId.add(R.drawable.oone);
	        imageId.add(R.drawable.two);
	        imageId.add(R.drawable.three);
	        imageId.add(R.drawable.five);
	    }
	 
	    public ArrayList<Integer> getImageItem() {
	        return imageId;
	    }
	
}
