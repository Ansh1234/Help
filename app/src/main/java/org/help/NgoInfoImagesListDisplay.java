package org.help;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class NgoInfoImagesListDisplay extends ActionBarActivity {

	public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.ngo_info_images_list_display);
	        NgoInfoImages ngoInfoImages  = new NgoInfoImages();
	        ArrayList<Integer> imageIds = ngoInfoImages.getImageItem();
	        LinearLayout NgoInfoImagesListDisplayLinearLayout=(LinearLayout)findViewById(R.id.ngo_info_images_list_display_linearlayout);
	        
	        for(int i=0;i<imageIds.size();i++){
	        	
	        	ImageView imageview = new ImageView(this);
	        	imageview.setBackgroundResource(imageIds.get(i));
	        	
				LayoutParams buttonLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	        	buttonLayoutParams.setMargins(0, 0, 0, 40);
	        	imageview.setLayoutParams(buttonLayoutParams);
	        	imageview.setOnClickListener(new View.OnClickListener() {
	                public void onClick(View v) {
	                	
	                	Intent intent = new Intent(getBaseContext(),NgoInfoImagesDisplay.class);
	                	startActivity(intent);
	                }
	            });
	        	NgoInfoImagesListDisplayLinearLayout.addView(imageview);
	        }
	        		
	  }
	

}
