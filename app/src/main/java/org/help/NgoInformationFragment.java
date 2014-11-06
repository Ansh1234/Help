package org.help;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class NgoInformationFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
   
		View rootView = inflater.inflate(R.layout.ngo_information, container, false);
			
		ImageView ngoInfoDisplayImage = (ImageView) rootView.findViewById(R.id.ngo_info_display_image);
		
		// When e user clicks on the image, a listview of images is opened.
		ngoInfoDisplayImage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                	
                	Intent intent = new Intent(getActivity(),NgoInfoImagesListDisplay.class);
                	startActivity(intent);
                }
      });
		TextViewEx txtViewEx = (TextViewEx) rootView.findViewById(R.id.ngo_info_description);
	    txtViewEx.setText("GOONJ’s mission is to make clothing a matter of concern. All our products are made from the last strands and shreds of the cloth, paper and other household material we get after sorting out the wearable, usable stuff. This product is made out of torn cloth/jeans, audio tapes etc. people discard in droves. There are no designer minds at work; it’s largely the ingenuity of our own minds.", true); // true: enables justification
			
	/*	LinearLayout ngoInfoCall = (LinearLayout) rootView.findViewById(R.id.ngo_info_call);
		
		//When the user clicks on call, directly the given number will be dialled.
		ngoInfoCall.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	 Intent intent = new Intent("android.intent.action.CALL");
                     Uri data = Uri.parse("tel:"+ "8124379096");
                     intent.setData(data);
                     startActivity(intent);
                }
            });
			
		LinearLayout ngoInfoEmail = (LinearLayout) rootView.findViewById(R.id.ngo_info_email);
		
		//When the user clicks on Email, directly the email will be sent.
		ngoInfoEmail.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	
                	Intent i = new Intent(Intent.ACTION_SEND);
                	i.setType("message/rfc822");
                	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"anshul.jain010@gmail.com"});
                	i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                	i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                	try {
                	    startActivity(Intent.createChooser(i, "Send mail..."));
                	} catch (android.content.ActivityNotFoundException ex) {
                	    Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                	}
                }
            });*/
		
		/*ImageView ngoInfoDirections = (ImageView) rootView.findViewById(R.id.ngo_info_directions);
		ngoInfoDirections.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
            	Intent intent = new Intent(getActivity(),NgoInfoDirections.class);
            	startActivity(intent);
            }
        });*/
		

			
		
	
		return rootView;
}
}
