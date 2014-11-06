package org.help;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class NgoInfoImagesDisplay extends ActionBarActivity implements OnPageChangeListener, OnClickListener {
 
    private ViewPager viewPage;
    private ArrayList<Integer> itemData;
    private NgoInfoImagesFragmentPagerAdapter adapter;
    private NgoInfoImages imageId;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_page);
 
        viewPage = (ViewPager) findViewById(R.id.viewPager);
        imageId = new NgoInfoImages();
        itemData = imageId.getImageItem();
        itemData.size();
 
        adapter = new NgoInfoImagesFragmentPagerAdapter(getSupportFragmentManager(),
                itemData);
        viewPage.setAdapter(adapter);
        viewPage.setOnPageChangeListener(NgoInfoImagesDisplay.this);
 
      
 
    }
 
  
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }
    @Override
    public void onPageSelected(int position) {
    
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
 	
}